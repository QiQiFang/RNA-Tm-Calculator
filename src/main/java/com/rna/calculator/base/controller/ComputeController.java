package com.rna.calculator.base.controller;

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
    public ComputeResultEnity compute(@RequestParam String inputElement, @RequestParam Double variableNa, @RequestParam Double variableC) {
        RequestEnity requestEnity = new RequestEnity();
        requestEnity.setInputElement(inputElement);
        requestEnity.setVariableC(variableC);
        requestEnity.setVariableNa(variableNa);
        return service.compute(requestEnity);
    }

}
