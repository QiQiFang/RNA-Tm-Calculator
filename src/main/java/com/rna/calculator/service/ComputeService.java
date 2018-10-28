package com.rna.calculator.service;

import com.rna.calculator.base.component.ComputeElementMappingLoader;
import com.rna.calculator.base.component.SimpleBaseTableLoader;
import com.rna.calculator.base.enity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.rna.calculator.base.enity.BaseConstant.COMPUTE_TYPES;
import static com.rna.calculator.base.enity.SimpleBaseTableEnity.COMPUTE_TYPE_H;
import static com.rna.calculator.base.enity.VariableEnity.VARIABLE_A;
import static com.rna.calculator.base.enity.VariableEnity.VARIABLE_R;

@Service
public class ComputeService {

    @Autowired
    private SimpleBaseTableLoader simpleBaseTableLoader;

    @Autowired
    private ComputeElementMappingLoader map;

    /**
     * 返回基础表格方法
     *
     * @return 表格数据
     */
    public List<SimpleBaseTableEnity> getBaseTable() {
        return simpleBaseTableLoader.getTableData();
    }

    /**
     * 计算服务
     *
     * @param requestEnity .inputElement  只接受 AUCG 四种元素的组合，前台判断是否合法
     *                     .na
     *                     .c
     * @return 计算结果
     */
    public ComputeResultEnity compute(RequestEnity requestEnity) {
        ComputeResultEnity result = new ComputeResultEnity();
        if (!isContinue(requestEnity)) {
            return result;
        }
        result.setVariableC(requestEnity.getVariableC());
        result.setVariableNa(requestEnity.getVariableNa());
        result.setSource(requestEnity.getInputElement());
        result.setMappingElement(this.getMappingElement(requestEnity.getInputElement()));
        result.setElements(this.initComputeElement(requestEnity.getInputElement(), result.getMappingElement()));
        this.fillingNumber(result.getElements());
        this.computeResultHandS(result);
        this.supplement(requestEnity, result);
        this.computeResult(result);
        return result;
    }

    /**
     * 补充 H和S的值，用于手算单个5'或3'时使用。后续会重构为自动计算5' 3'附加值的方法复用。
     *
     * @param result
     */
    private void supplement(RequestEnity requestEnity, ComputeResultEnity result) {
        if (requestEnity.getSupplementH() != null && requestEnity.getSupplementS() != null) {
            result.setResultH(new BigDecimal(requestEnity.getSupplementH()).add(new BigDecimal(result.getResultH())).doubleValue());
            result.setResultS(new BigDecimal(requestEnity.getSupplementS()).add(new BigDecimal(result.getResultS())).doubleValue());
        }

    }

    /**
     * 是否可以继续计算，如果缺少参数则直接返回
     *
     * @param requestEnity
     * @return
     */
    private boolean isContinue(RequestEnity requestEnity) {
        if(StringUtils.isEmpty(requestEnity.getInputElement())){
            return requestEnity.getSupplementH() !=null && requestEnity.getSupplementS() != null
                    && requestEnity.getVariableC() != null && requestEnity.getVariableNa() != null;
        }
        return !StringUtils.isEmpty(requestEnity.getInputElement()) &&
                requestEnity.getVariableC() != null &&
                requestEnity.getVariableNa() != null;
    }

    /**
     * 计算Tm
     * Tm = H / ( A + (S / 1000) + (R * Math.log(C/4)) - 273.15 + (16.6 * Math.log10(Na))
     *
     * @param result
     */
    private void computeResult(ComputeResultEnity result) {
        double tm = new BigDecimal(String.valueOf(result.getResultH()))
                .divide(new BigDecimal(String.valueOf(VARIABLE_A))
                        .add(new BigDecimal(
                                new BigDecimal(String.valueOf(result.getResultS()))
                                        .divide(new BigDecimal(String.valueOf(1000)), 10, BigDecimal.ROUND_HALF_UP).toString())
                                .add(new BigDecimal(String.valueOf(VARIABLE_R))
                                        .multiply(new BigDecimal(Math.log(new BigDecimal(String.valueOf(result.getVariableC()))
                                                .divide(new BigDecimal(String.valueOf(4)), 10, BigDecimal.ROUND_HALF_UP).doubleValue()))))), 10, BigDecimal.ROUND_HALF_UP)
                .subtract(new BigDecimal(String.valueOf(273.15)))
                .add(new BigDecimal(new BigDecimal(String.valueOf(16.6))
                        .multiply(new BigDecimal(Math.log10(result.getVariableNa()))).toString())).doubleValue();
        result.setResultTm(new BigDecimal(tm).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    /**
     * 计算结果H /S
     *
     * @param result 结果对象
     */
    private void computeResultHandS(ComputeResultEnity result) {
        double resultH = 0.0;
        double resultS = 0.0;
        for (ComputeElementEnity e : result.getElements()) {
            resultH = new BigDecimal(String.valueOf(resultH)).add(new BigDecimal(String.valueOf(e.getValueH()))).doubleValue();
            resultS = new BigDecimal(String.valueOf(resultS)).add(new BigDecimal(String.valueOf(e.getValueS()))).doubleValue();
        }
        result.setResultH(resultH);
        result.setResultS(resultS);
    }

    /**
     * 填入实际值
     *
     * @param elementList 计算元素
     */
    private void fillingNumber(List<ComputeElementEnity> elementList) {
        elementList.forEach(e -> COMPUTE_TYPES.forEach(t ->
                simpleBaseTableLoader.getTableData()
                        .stream()
                        .filter(b -> b.getComputeType().equals(t))
                        .filter(f -> f.getBasePairfirst().equals(e.getNodeElementEnity().getFirstNode()))
                        .filter(x -> x.getAxisTypeX().equals(e.getNodeElementEnity().getAxisXNode()))
                        .forEach(baseLine -> {
                            if (t == COMPUTE_TYPE_H) {
                                e.setValueH(baseLine.getValue(e.getNodeElementEnity().getAxisYNode()));
                                return;
                            }
                            e.setValueS(baseLine.getValue(e.getNodeElementEnity().getAxisYNode()));
                        })
        ));
    }

    /**
     * 初始化计算元素
     *
     * @param source  入参源组合数据
     * @param mapping 映射后的组合
     * @return 计算元素
     */
    private List<ComputeElementEnity> initComputeElement(String source, String mapping) {
        List<ComputeElementEnity> elementList = new ArrayList<>();
        //初始版source与mapping的size相同所以一起遍历。
        //逐一遍历，第二列的节点元素通过当前坐标+1来获取，如果+1>size则代表到达最后不再生成计算元素
        char[] sourceArr = source.toCharArray();
        char[] mappingArr = mapping.toCharArray();
        for (int i = 0; i < sourceArr.length; i++) {
            if (i != sourceArr.length - 1) {
                ComputeElementEnity element = new ComputeElementEnity();
                element.getNodeElementEnity().setFirstNode(String.valueOf(sourceArr[i]));
                element.getNodeElementEnity().setAxisXNode(String.valueOf(sourceArr[i + 1]));
                element.getNodeElementEnity().setThirdNode(String.valueOf(mappingArr[i]));
                element.getNodeElementEnity().setAxisYNode(String.valueOf(mappingArr[i + 1]));
                elementList.add(element);
            }
        }
        return elementList;
    }

    /**
     * 映射
     *
     * @param inputElement
     * @return
     */
    private String getMappingElement(String inputElement) {
        char[] element = inputElement.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char e : element) {
            sb.append(map.getElementMapping(String.valueOf(e)));
        }
        return sb.toString();
    }


}
