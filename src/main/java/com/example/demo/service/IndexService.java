package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.demo.Stock;
import com.example.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**

 */
@Service
public class IndexService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
/*    public List<Student> getList(){
        String sql="select id,name,age from Student";
        List<Student> students=jdbcTemplate.query(sql,new MyRowMapper());
    }*/

    public List<Stock> getList(){
        System.out.println("******************************");
        String sql = "SELECT stockcode,stockname,holding,newest_price FROM stocks";
        return (List<Stock>) jdbcTemplate.query(sql, new RowMapper<Stock>(){

            @Override//重写方法的注解
            public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
                Stock stock = new Stock();//新建一个stock对象
                stock.setStockcode(rs.getString("stockcode"));
                stock.setStockname(rs.getString("stockname"));
                stock.setHolding(rs.getInt("holding"));
                stock.setNewest_price(rs.getFloat("newest_price"));
           //     System.out.println(rs);
             //   System.out.println(rs.getString("stockcode"));
              //  System.out.println(rs.getString("stockname"));
               // System.out.println(rs.getInt("holding"));

                return stock;
                //  return null;
            }

        });
    }

}