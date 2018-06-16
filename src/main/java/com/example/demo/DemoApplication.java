package com.example.demo;

import com.example.demo.JDBC.JDBCOperater;
import com.example.demo.dao.impl.StockDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.IStockService;
import com.example.demo.Student;

import java.io.File;
import java.util.List;
import org.springframework.context.*;
import org.springframework.context.support.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {//主程序入口
        SpringApplication.run(DemoApplication.class, args);
        //System.out.println("*********************************");
       // Student student=new Student();//新建一个student对象并初始化
      //  student.setAge(12);
       // student.setId(8);
       // student.setName("AAAAABBB");
     //     ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Database.xml");
       // ApplicationContext context = new FileSystemXmlApplicationContext("D:\\Spring-Database.xml");
     //   JDBCOperater jdbcOp = (JDBCOperater) context.getBean("student");//创建一个JDBC操作对象
     //   jdbcOp.insertNamedParameter(student);//调用这个对象里的插入方法









    //    File file = new File("/");
    //    System.out.println("/ 代表的绝对路径为：" + file.getAbsolutePath());
    //    File file1 = new File("./src/main/resources");
    //    System.out.println(". 代表的绝对路径为" + file1.getAbsolutePath());
      //  ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/Spring-Database.xml");
      //  JDBCOperater jdbcOp = (JDBCOperater) context.getBean("student");//创建一个JDBC操作对象
      //  jdbcOp.insertNamedParameter(student);//调用这个对象里的插入方法

    }
}
