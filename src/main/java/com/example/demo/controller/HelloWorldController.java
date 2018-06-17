package com.example.demo.controller;

import com.example.demo.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class HelloWorldController {
    @Autowired
  //  IStockService stockService;

    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String index(){
        return "XPS said 'hello spring boot' after crying many times.";
    }
}
