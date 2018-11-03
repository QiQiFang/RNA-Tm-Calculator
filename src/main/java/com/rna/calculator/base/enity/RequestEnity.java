package com.rna.calculator.base.enity;

/**
 * 计算入参实体类
 * @author fang.qiqi
 */
public class RequestEnity extends VariableEnity {

    private String inputElement;


    /**
     * 与录入数据相映射的数据
     */
    private String mappingElement;


    // 补充 3' 5'序列
    private String left5Seq;

    private String left3Seq;

    private String right3Seq;

    private String right5Seq;

    public String getMappingElement() {
        return mappingElement;
    }

    public void setMappingElement(String mappingElement) {
        this.mappingElement = mappingElement;
    }

    public String getLeft5Seq() {
        return left5Seq;
    }

    public void setLeft5Seq(String left5Seq) {
        this.left5Seq = left5Seq;
    }

    public String getLeft3Seq() {
        return left3Seq;
    }

    public void setLeft3Seq(String left3Seq) {
        this.left3Seq = left3Seq;
    }

    public String getRight3Seq() {
        return right3Seq;
    }

    public void setRight3Seq(String right3Seq) {
        this.right3Seq = right3Seq;
    }

    public String getRight5Seq() {
        return right5Seq;
    }

    public void setRight5Seq(String right5Seq) {
        this.right5Seq = right5Seq;
    }

    public String getInputElement() {
        return inputElement;
    }

    public void setInputElement(String inputElement) {
        this.inputElement = inputElement;
    }


}
