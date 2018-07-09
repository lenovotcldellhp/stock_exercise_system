package com.example.demo.service;

import com.example.demo.record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
/*    public List<Student> getList(){
        String sql="select id,name,age from Student";
        List<Student> students=jdbcTemplate.query(sql,new MyRowMapper());
    }*/

    public List<record> getList(){
        System.out.println("******************************");
        String sql = "SELECT * FROM record";
        return (List<record>) jdbcTemplate.query(sql, new RowMapper<record>(){

            @Override//重写方法的注解
            public record mapRow(ResultSet rs, int rowNum) throws SQLException {
                record rec = new record();//新建一个rec对象
                rec.setCount(rs.getInt("count"));
                rec.setPrice(rs.getFloat("price"));
                rec.setMoney(rs.getFloat("money"));
                rec.setType(rs.getString("type"));
                rec.setStockcode(rs.getString("stockcode"));
                rec.setTime(rs.getString("time"));

                return rec;
                //  return null;
            }

        });
    }
    
    
}
