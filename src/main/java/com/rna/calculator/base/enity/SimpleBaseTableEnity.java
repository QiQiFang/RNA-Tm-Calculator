package com.rna.calculator.base.enity;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static com.rna.calculator.base.enity.BaseConstant.*;

/**
 * 简单版本Table实体类
 */
public class SimpleBaseTableEnity implements Serializable {
    public static final int COMPUTE_TYPE_H = 1;

    public static final int COMPUTE_TYPE_S = 2;
    /**
     * 用来保存实际值的缓存Map
     */
    private Map<String, Double> valueMap = new HashMap<>();

    private Integer computeType;

    private String basePair;
    /**
     * BasePair 首字母，用来检索使用
     */
    private String basePairfirst;
    /**
     * A C G U
     */
    private String axisTypeX;


    /**
     * Y轴数值
     */
    private Double yAxisValueA;

    private Double yAxisValueC;

    private Double yAxisValueG;

    private Double yAxisValueU;

    private String computeTypeName;


    public String getComputeTypeName() {
        return computeTypeName;
    }

    public Double getValue(String key) {
        return this.valueMap.get(key);
    }

    public void setyAxisValueA(Double yAxisValueA) {
        this.yAxisValueA = yAxisValueA;
        this.valueMap.putIfAbsent(A, yAxisValueA);
    }

    public void setyAxisValueC(Double yAxisValueC) {
        this.yAxisValueC = yAxisValueC;
        this.valueMap.putIfAbsent(C, yAxisValueC);
    }

    public void setyAxisValueG(Double yAxisValueG) {
        this.yAxisValueG = yAxisValueG;
        this.valueMap.putIfAbsent(G, yAxisValueG);
    }

    public void setyAxisValueU(Double yAxisValueU) {
        this.yAxisValueU = yAxisValueU;
        this.valueMap.putIfAbsent(U, yAxisValueU);
    }


    public Double getyAxisValueA() {
        return yAxisValueA;
    }


    public Double getyAxisValueC() {
        return yAxisValueC;
    }


    public Double getyAxisValueG() {
        return yAxisValueG;
    }


    public Double getyAxisValueU() {
        return yAxisValueU;
    }


    public Integer getComputeType() {
        return computeType;
    }

    public void setComputeType(Integer computeType) {
        this.computeType = computeType;
        if(computeType == COMPUTE_TYPE_H){
            this.computeTypeName = "H";
        }else {
            this.computeTypeName ="S";
        }
    }

    public String getBasePair() {
        return basePair;
    }

    public void setBasePair(String basePair) {
        this.basePair = basePair;
        if (!StringUtils.isEmpty(basePair)) {
            this.basePairfirst = basePair.substring(0, 1);
        }
    }

    public String getBasePairfirst() {
        return basePairfirst;
    }

    public String getAxisTypeX() {
        return axisTypeX;
    }

    public void setAxisTypeX(String axisTypeX) {
        this.axisTypeX = axisTypeX;
    }

}
