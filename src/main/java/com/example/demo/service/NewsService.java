package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.example.demo.news;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
/*    public List<Student> getList(){
        String sql="select id,name,age from Student";
        List<Student> students=jdbcTemplate.query(sql,new MyRowMapper());
    }*/

    public List<news> getList(){
        System.out.println("******************************");
        String sql = "SELECT * FROM news";
        return (List<news>) jdbcTemplate.query(sql, new RowMapper<news>(){

            @Override//重写方法的注解
            public news mapRow(ResultSet rs, int rowNum) throws SQLException {
                news rec = new news();//新建一个rec对象
                rec.setTitle(rs.getString("title"));
                rec.setUrl(rs.getString("url"));
                //rec.setMoney(rs.getFloat("money"));
             //   rec.setType(rs.getString("type"));
             //   rec.setStockcode(rs.getString("stockcode"));
             //   rec.setTime(rs.getString("time"));

                return rec;
                //  return null;
            }

        });
    }


}
