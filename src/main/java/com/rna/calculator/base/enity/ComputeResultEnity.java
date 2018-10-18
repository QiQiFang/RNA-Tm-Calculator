package com.rna.calculator.base.enity;

import java.io.Serializable;
import java.util.List;

/**
 * 用来返回结果使用
 */
public class ComputeResultEnity implements Serializable {

    /**
     * 与录入数据相映射的数据
     */
    private String mappingElement;

    /**
     * 生成的计算元素
     */
    private List<ComputeElementEnity> elements;

    private Double resultH;

    private Double resultS;

    public String getMappingElement() {
        return mappingElement;
    }

    public void setMappingElement(String mappingElement) {
        this.mappingElement = mappingElement;
    }

    public List<ComputeElementEnity> getElements() {
        return elements;
    }

    public void setElements(List<ComputeElementEnity> elements) {
        this.elements = elements;
    }

    public Double getResultH() {
        return resultH;
    }

    public void setResultH(Double resultH) {
        this.resultH = resultH;
    }

    public Double getResultS() {
        return resultS;
    }

    public void setResultS(Double resultS) {
        this.resultS = resultS;
    }
}
