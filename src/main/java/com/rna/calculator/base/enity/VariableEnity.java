package com.rna.calculator.base.enity;

import java.io.Serializable;

/**
 * 计算变量实体类
 */
public class VariableEnity implements Serializable {

    private Double variableNa;

    private Double variableC;

    private Double supplementH;

    private Double supplementS;


    public static final double VARIABLE_A = -0.0108;

    public static final double VARIABLE_R = 0.00199;


    public Double getSupplementH() {
        return supplementH;
    }

    public void setSupplementH(Double supplementH) {
        this.supplementH = supplementH;
    }

    public Double getSupplementS() {
        return supplementS;
    }

    public void setSupplementS(Double supplementS) {
        this.supplementS = supplementS;
    }

    public Double getVariableNa() {
        return variableNa;
    }

    public void setVariableNa(Double variableNa) {
        this.variableNa = variableNa;
    }

    public Double getVariableC() {
        return variableC;
    }

    public void setVariableC(Double variableC) {
        this.variableC = variableC;
    }
}
