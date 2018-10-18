package com.rna.calculator.base.component;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.rna.calculator.base.enity.BaseConstant.*;

/**
 * @author fang.qiqi
 */
@Component
public class ComputeElementLoader {
    private Map<String,String> computeElementMap;

    public ComputeElementLoader(){
        computeElementMap = new HashMap<>();
        computeElementMap.put(A,U);
        computeElementMap.put(U,A);
        computeElementMap.put(C,G);
        computeElementMap.put(G,C);
    }
    public String getElementMapping(String element){
        return this.computeElementMap.get(element);
    }
}
