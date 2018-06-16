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

      //  getFiledName(model);
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        //输出greeting对象里的内容
        System.out.println(greeting.getId());
        System.out.println(greeting.getContent());
       // Student student=new Student();//新建一个student对象并初始化
     //   student.setAge(12);
        //student.setId(8);
        //student.setName("AAAAABBB");
        //  ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/Spring-Database.xml");
        //ApplicationContext context = new FileSystemXmlApplicationContext("Spring-Database.xml");
       // JDBCOperater jdbcOp = (JDBCOperater) context.getBean("student");//创建一个JDBC操作对象
        // jdbcOp.insertNamedParameter(student);//调用这个对象里的插入方法
        return "result";
    }


}
