package com.rna.calculator.controller;

import com.rna.calculator.base.enity.ComputeResultEnity;
import com.rna.calculator.base.enity.RequestEnity;
import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import com.rna.calculator.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ComputeController {

    @Autowired
    private ComputeService service;


    @GetMapping(value = "/getbasetable")
    @ResponseBody
    public List<SimpleBaseTableEnity> getBaseTable() {
        return service.getBaseTable();
    }

    @GetMapping(value = "/compute")
    @ResponseBody
    public ComputeResultEnity compute(@RequestParam String inputElement,
                                      @RequestParam Double variableNa,
                                      @RequestParam Double variableC,
                                      @RequestParam String left5Seq,
                                      @RequestParam String left3Seq,
                                      @RequestParam String right3Seq,
                                      @RequestParam String right5Seq) {
        RequestEnity requestEnity = new RequestEnity();
        requestEnity.setInputElement(inputElement);
        requestEnity.setVariableC(variableC);
        requestEnity.setVariableNa(variableNa);
        requestEnity.setLeft5Seq(left5Seq);
        requestEnity.setLeft3Seq(left3Seq);
        requestEnity.setRight3Seq(right3Seq);
        requestEnity.setRight5Seq(right5Seq);
        return service.compute(requestEnity);
    }

}
