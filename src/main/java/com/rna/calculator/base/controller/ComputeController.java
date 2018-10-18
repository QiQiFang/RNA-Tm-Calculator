package com.rna.calculator.base.controller;

import com.rna.calculator.base.enity.ComputeResultEnity;
import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import com.rna.calculator.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ComputeController {

    @Autowired
    private ComputeService service;


    @RequestMapping(value = "/getbasetable", method = RequestMethod.GET)
    @ResponseBody
    public List<SimpleBaseTableEnity> getBaseTable() {
        return service.getBaseTable();
    }

    @RequestMapping(value = "/compute", method = RequestMethod.GET)
    @ResponseBody
    public ComputeResultEnity compute(String inputElement){
        return service.compute(inputElement);
    }

}
