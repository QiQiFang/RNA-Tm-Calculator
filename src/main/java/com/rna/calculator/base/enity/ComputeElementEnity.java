package com.rna.calculator.base.enity;

import java.io.Serializable;

/**
 *  计算元素实体类
 */
public class ComputeElementEnity implements Serializable {

    /**
     * 保存4个节点小元素对象
     */
    private NodeElementEnity nodeElementEnity;
    /**
     * H
     */
    private Double valueH;
    /**
     * S
     */
    private Double valueS;


    public NodeElementEnity getNodeElementEnity() {
        return nodeElementEnity;
    }

    public void setNodeElementEnity(NodeElementEnity nodeElementEnity) {
        this.nodeElementEnity = nodeElementEnity;
    }

    public Double getValueH() {
        return valueH;
    }

    public void setValueH(Double valueH) {
        this.valueH = valueH;
    }

    public Double getValueS() {
        return valueS;
    }

    public void setValueS(Double valueS) {
        this.valueS = valueS;
    }
}
