package com.rna.calculator.base.enity;

import java.io.Serializable;

/**
 * 每个计算元素中包含的小节点元素对象
 *
 * @author fang.qiqi
 */
public class NodeElementEnity implements Serializable {

    /**
     * 第一行第一个小节点,用来决定使用那种basePair
     */
    private String firstNode;
    /**
     * 第一行第二个节点，用来决定X轴使用哪一行table
     */
    private String axisXNode;
    /**
     * 第二行第一个元素，也就是第三个元素
     */
    private String thirdNode;

    /**
     * 第二行第二个元素，用来确定在Table中的Y轴数值位置
     */
    private String axisYNode;

    public String getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(String firstNode) {
        this.firstNode = firstNode;
    }

    public String getAxisXNode() {
        return axisXNode;
    }

    public void setAxisXNode(String axisXNode) {
        this.axisXNode = axisXNode;
    }

    public String getThirdNode() {
        return thirdNode;
    }

    public void setThirdNode(String thirdNode) {
        this.thirdNode = thirdNode;
    }

    public String getAxisYNode() {
        return axisYNode;
    }

    public void setAxisYNode(String axisYNode) {
        this.axisYNode = axisYNode;
    }
}
