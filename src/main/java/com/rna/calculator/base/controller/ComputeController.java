package com.rna.calculator.base.controller;

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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public List<SimpleBaseTableEnity> testTable() {
        return service.testTable();
    }

}
