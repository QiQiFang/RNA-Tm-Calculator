package com.rna.calculator.base.component;

import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.rna.calculator.base.enity.BaseConstant.*;
import static com.rna.calculator.base.enity.SimpleBaseTableEnity.COMPUTE_TYPE_H;
import static com.rna.calculator.base.enity.SimpleBaseTableEnity.COMPUTE_TYPE_S;

/**
 * 17/Oct/2018
 * 用于加载简单版本基础Table使用
 *
 * @author fang.qiqi
 */
@Component
public class SimpleBaseTableLoader {
    private List<SimpleBaseTableEnity> tableEnitys;

    private static final String A_X_U_Y = "AXUY";

    private static final String C_X_G_Y = "CXGY";

    private static final String G_X_C_Y = "GXCY";

    private static final String U_X_A_Y = "UXAY";


    public SimpleBaseTableLoader() {
        tableEnitys = new ArrayList<>();
        //H
        tableEnitys.add(getTableEnityTypeH(A_X_U_Y, A, -3.9, 2.0, -3.5, -6.6));
        tableEnitys.add(getTableEnityTypeH(A_X_U_Y, C, -2.3, 6.0, -10.2, -0.3));
        tableEnitys.add(getTableEnityTypeH(A_X_U_Y, G, -3.1, -7.6, -3.5, -2.7));
        tableEnitys.add(getTableEnityTypeH(A_X_U_Y, U, -5.7, 4.6, -4.0, -1.7));

        tableEnitys.add(getTableEnityTypeH(C_X_G_Y, A, -9.1, -5.6, -5.6, -10.5));
        tableEnitys.add(getTableEnityTypeH(C_X_G_Y, C, -5.7, -3.4, -12.2, -2.7));
        tableEnitys.add(getTableEnityTypeH(C_X_G_Y, G, -8.2, -8.0, -9.2, -3.1));
        tableEnitys.add(getTableEnityTypeH(C_X_G_Y, U, -7.6, -5.3, -11.2, -8.6));

        tableEnitys.add(getTableEnityTypeH(G_X_C_Y, A, -5.2, -4.0, -5.6, -13.3));
        tableEnitys.add(getTableEnityTypeH(G_X_C_Y, C, -7.2, 0.5, -14.2, -4.2));
        tableEnitys.add(getTableEnityTypeH(G_X_C_Y, G, -7.1, -12.2, -6.2, -6.3));
        tableEnitys.add(getTableEnityTypeH(G_X_C_Y, U, -10.2, -0.3, -9.5, -5.0));

        tableEnitys.add(getTableEnityTypeH(U_X_A_Y, A, -4.0, -6.3, -8.9, -8.1));
        tableEnitys.add(getTableEnityTypeH(U_X_A_Y, C, -4.3, -5.1, -13.3, -1.8));
        tableEnitys.add(getTableEnityTypeH(U_X_A_Y, G, -3.8, -10.5, -8.9, -8.5));
        tableEnitys.add(getTableEnityTypeH(U_X_A_Y, U, -6.6, -1.4, -13.6, 1.4));

        //S
        tableEnitys.add(getTableEnityTypeS(A_X_U_Y, A, -10.2, 9.6, -8.7, -18.4));
        tableEnitys.add(getTableEnityTypeS(A_X_U_Y, C, -5.3, 21.6, -26.2, 1.5));
        tableEnitys.add(getTableEnityTypeS(A_X_U_Y, G, -7.3, -19.2, -8.7, -7.0));
        tableEnitys.add(getTableEnityTypeS(A_X_U_Y, U, -15.5, 17.4, -9.7, -2.7));

        tableEnitys.add(getTableEnityTypeS(C_X_G_Y, A, -24.5, -13.5, -13.4, -27.8));
        tableEnitys.add(getTableEnityTypeS(C_X_G_Y, C, -15.2, -7.6, -29.7, -6.3));
        tableEnitys.add(getTableEnityTypeS(C_X_G_Y, G, -21.8, -19.4, -24.6, -6.2));
        tableEnitys.add(getTableEnityTypeS(C_X_G_Y, U, -19.2, -12.6, -30.1, -23.9));

        tableEnitys.add(getTableEnityTypeS(G_X_C_Y, A, -13.2, -8.2, -13.9, -35.5));
        tableEnitys.add(getTableEnityTypeS(G_X_C_Y, C, -19.6, 3.9, -34.9, -12.2));
        tableEnitys.add(getTableEnityTypeS(G_X_C_Y, G, -17.8, -29.7, -15.1, -15.8));
        tableEnitys.add(getTableEnityTypeS(G_X_C_Y, U, -26.2, 2.1, -23.9, -14.0));

        tableEnitys.add(getTableEnityTypeS(U_X_A_Y, A, -9.7, -17.7, -25.2, -22.6));
        tableEnitys.add(getTableEnityTypeS(U_X_A_Y, C, -11.6, -14.6, -35.5, -4.2));
        tableEnitys.add(getTableEnityTypeS(U_X_A_Y, G, -8.5, -27.8, -25.0, -24.9));
        tableEnitys.add(getTableEnityTypeS(U_X_A_Y, U, -18.4, -2.5, -40.2, 6.0));


    }


    public List<SimpleBaseTableEnity> getTableData() {
        return this.tableEnitys;
    }

    private SimpleBaseTableEnity getTableEnityTypeH(String basePair, String axisTypeX, double yAxisValueA,
                                                    double yAxisValueC, double yAxisValueG, double yAxisValueU
    ) {
        return this.getTableEnity(basePair, axisTypeX, yAxisValueA, yAxisValueC, yAxisValueG, yAxisValueU, COMPUTE_TYPE_H);
    }

    private SimpleBaseTableEnity getTableEnityTypeS(String basePair, String axisTypeX, double yAxisValueA,
                                                    double yAxisValueC, double yAxisValueG, double yAxisValueU) {
        return this.getTableEnity(basePair, axisTypeX, yAxisValueA, yAxisValueC, yAxisValueG, yAxisValueU, COMPUTE_TYPE_S);
    }

    private SimpleBaseTableEnity getTableEnity(String basePair, String axisTypeX, double yAxisValueA,
                                               double yAxisValueC, double yAxisValueG, double yAxisValueU,
                                               int computeType) {
        SimpleBaseTableEnity enity = new SimpleBaseTableEnity();
        enity.setBasePair(basePair);
        enity.setAxisTypeX(axisTypeX);
        enity.setComputeType(computeType);
        enity.setyAxisValueA(yAxisValueA);
        enity.setyAxisValueC(yAxisValueC);
        enity.setyAxisValueG(yAxisValueG);
        enity.setyAxisValueU(yAxisValueU);
        return enity;
    }
}
