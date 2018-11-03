package com.rna.calculator.base.enity;

import java.io.Serializable;

/**
 * 计算变量实体类
 */
public class VariableEnity implements Serializable {

    private Double variableNa;

    private Double variableC;



    public static final double VARIABLE_A = -0.0108;

    public static final double VARIABLE_R = 0.00199;


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
