package com.rna.calculator.service;

import com.rna.calculator.base.component.SimpleBaseTableLoader;
import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputeService {
    @Autowired
    private SimpleBaseTableLoader simpleBaseTableLoader;

    public List<SimpleBaseTableEnity> testTable(){
        List<SimpleBaseTableEnity> dataList =  simpleBaseTableLoader.getTableData();
        System.out.println(dataList);
        return dataList;
    }
}
