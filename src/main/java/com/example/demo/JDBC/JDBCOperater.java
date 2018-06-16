package com.example.demo.JDBC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Student;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
public class JDBCOperater extends NamedParameterJdbcDaoSupport {


    public void insertNamedParameter(Student student) {
        String sql = "INSERT INTO Student(ID, NAME, AGE)"
                + "VALUES(:id, :name, :age)";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", student.getName());
        parameters.put("age", student.getAge());
        parameters.put("id", student.getId());

        getNamedParameterJdbcTemplate().update(sql, parameters);
    }

    public Student findByStudentId(int Id) {
        String sql = "SELECT * FROM Student WHERE ID = ?";
        Student student = getJdbcTemplate().queryForObject(sql, new Object[] {Id}, new BeanPropertyRowMapper<Student>(Student.class));
        return student;
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM Student";

        List<Student> students = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return students;
    }

}
