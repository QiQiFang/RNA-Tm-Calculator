package com.rna.calculator.service;

import com.rna.calculator.base.component.ComputeElementMappingLoader;
import com.rna.calculator.base.component.SimpleBaseTableLoader;
import com.rna.calculator.base.enity.ComputeResultEnity;
import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        result.setMappingElement(this.getMappingElement(inputElement));

        return result;
    }

    private String getMappingElement(String inputElement) {
        char[] element = inputElement.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char e : element) {
            sb.append(map.getElementMapping(String.valueOf(e)));
        }
        return sb.toString();
    }


}
