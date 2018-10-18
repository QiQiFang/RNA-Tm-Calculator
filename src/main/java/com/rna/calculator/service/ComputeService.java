package com.rna.calculator.service;

import com.rna.calculator.base.component.ComputeElementMappingLoader;
import com.rna.calculator.base.component.SimpleBaseTableLoader;
import com.rna.calculator.base.enity.ComputeElementEnity;
import com.rna.calculator.base.enity.ComputeResultEnity;
import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
     * @param inputElement 只接受 AUCG 四种元素的组合，前台判断是否合法
     * @return 计算结果
     */
    public ComputeResultEnity compute(String inputElement) {
        ComputeResultEnity result = new ComputeResultEnity();
        if (StringUtils.isEmpty(inputElement)) {
            return result;
        }
        result.setSource(inputElement);
        result.setMappingElement(this.getMappingElement(inputElement));
        result.setElements(this.initComputeElement(inputElement, result.getMappingElement()));
        return result;
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
