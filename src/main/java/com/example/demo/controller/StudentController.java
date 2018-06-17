package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.StudentService;
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
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    @GetMapping("/student")
    public String student(Model model)throws ParseException{
        List studentlist=studentService.getList();
        model.addAttribute("studentlist",studentlist);
        return "student";
    }


    @RequestMapping("/list")
    public List<Student> getStus(){
        logger.info("从数据库读取Student集合");
       // System.out.println(getStus());
     //   System.out.println(getStus(new ArrayList()));//直接输出List
     //   Student temp;
       // System.out.print(getStus().size());
      //  int i=0;
     //   for(i=0;i<getStus().size();i++){
      //      System.out.println(getStus().get(i));
      //  }
      //  return studentService.getList();

        List<Student> temp;
        temp=studentService.getList();
        int i=0;
        for(i=0;i<temp.size();i++){
            System.out.println("%%%%%%%%%%%%%%%%%%%%");
            System.out.println(temp.get(i).getName());
            System.out.println("#######################");
        }


        return temp;
      //  return studentService.getList();

    }
/*
    @RequestMapping(value="/student", method=RequestMethod.GET)
    public ModelAndView student() {
        Student st = new Student();
        return new ModelAndView("student", "command", st);
    }

    @RequestMapping(value="/addStudent", method=RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")Student student, Model model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Database.xml");
        JDBCOperater jdbcOp = (JDBCOperater) context.getBean("student");//创建一个JDBC操作对象
        jdbcOp.insertNamedParameter(student);//调用这个对象里的插入方法
        ((ConfigurableApplicationContext)context).close();
        return "result";
    }
    */
}