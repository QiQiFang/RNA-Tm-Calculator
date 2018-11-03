package com.rna.calculator.base.enity;

import java.io.Serializable;

public class ValueEnity implements Serializable {

    private String resultH;
    private String  resultS;

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
}
