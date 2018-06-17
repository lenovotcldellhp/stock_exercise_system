package com.example.demo.controller;

import com.example.demo.service.IndexService;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private IndexService indexService;

    @GetMapping("/index")
    public String student(Model model) throws ParseException {
        List indexlist = indexService.getList();
        int i=0;
        for(i=0;i<indexlist.size();i++){
            System.out.println(indexlist.get(i));
        }
        model.addAttribute("indexlist", indexlist);
        return "index";
    }
}

