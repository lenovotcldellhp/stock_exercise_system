package com.example.demo.controller;

import com.example.demo.JDBC.JDBCOperater;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.Greeting;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import java.lang.reflect.*;
import com.example.demo.Student;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        System.out.println("%%%%%%%%%%%%%");
        System.out.println(model.toString());
      //  getFiledName(model);
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        //输出greeting对象里的内容
        System.out.println(greeting.getId());
        System.out.println(greeting.getContent());
        System.out.println("使用第一个表单处理Controller");
        return "result";
    }
    @PostMapping("/greeting2")
    public String greetingSubmit2(@ModelAttribute Greeting greeting2) {
        //输出greeting对象里的内容
        System.out.println(greeting2.getId());
        System.out.println(greeting2.getContent());
        System.out.println("使用第二个表单处理Controller");
        return "result2";
    }

}
