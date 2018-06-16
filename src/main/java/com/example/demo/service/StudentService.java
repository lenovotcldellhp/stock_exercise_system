package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**

 */
@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
/*    public List<Student> getList(){
        String sql="select id,name,age from Student";
        List<Student> students=jdbcTemplate.query(sql,new MyRowMapper());
    }*/

    public List<Student> getList(){
        System.out.println("******************************");
        String sql = "SELECT id,name,age FROM Student";
        return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>(){

            @Override//重写方法的注解
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student stu = new Student();//新建一个student对象
                System.out.println(rs);
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("age"));
                System.out.println(rs.getString("name"));
                stu.setId(rs.getString("id"));
                stu.setAge(rs.getString("age"));
                stu.setName(rs.getString("name"));
             //   stu.setSumScore(rs.getString("SCORE_SUM"));
              //  stu.setAvgScore(rs.getString("SCORE_AVG"));
                return stu;
              //  return null;
            }

        });
    }

}