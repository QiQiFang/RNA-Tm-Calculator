package com.rna.calculator.controller;

import com.rna.calculator.base.enity.ComputeResultEnity;
import com.rna.calculator.base.enity.RequestEnity;
import com.rna.calculator.base.enity.SimpleBaseTableEnity;
import com.rna.calculator.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/compute")
    @ResponseBody
    public ComputeResultEnity compute(RequestEnity requestEnity) {
        return service.compute(requestEnity);
    }

}
