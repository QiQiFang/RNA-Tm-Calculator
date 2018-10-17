package com.rna.calculator.base;

import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 17/Oct/2018
 * 用于加载简单版本基础Table使用
 *
 * @author fang.qiqi
 */
@Component
public class SimpleBaseTableLoader {
    private List<SimpleBaseTableEnity> tableEnity;

    public SimpleBaseTableLoader() {
        //TODO init
    }

    public List<SimpleBaseTableEnity> getTableEnity() {
        return tableEnity;
    }
}
