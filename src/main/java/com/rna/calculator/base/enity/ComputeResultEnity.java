package com.rna.calculator.base.enity;

import java.util.List;

/**
 * 用来返回结果使用
 */
public class ComputeResultEnity extends RequestEnity{




    /**
     * 生成的计算元素
     */
    private List<ComputeElementEnity> elements;

    private List<ComputeElementEnity> supplementElements;

    private String resultH;

    private String resultS;

    private String resultTm;


    public List<ComputeElementEnity> getSupplementElements() {
        return supplementElements;
    }

    public void setSupplementElements(List<ComputeElementEnity> supplementElements) {
        this.supplementElements = supplementElements;
    }




    public List<ComputeElementEnity> getElements() {
        return elements;
    }

    public void setElements(List<ComputeElementEnity> elements) {
        this.elements = elements;
    }

    public String getResultH() {
        return resultH;
    }

    public void setResultH(String resultH) {
        this.resultH = resultH;
    }

    public String getResultS() {
        return resultS;
    }

    public void setResultS(String resultS) {
        this.resultS = resultS;
    }

    public String getResultTm() {
        return resultTm;
    }

    public void setResultTm(String resultTm) {
        this.resultTm = resultTm;
    }
}
