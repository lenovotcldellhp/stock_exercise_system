package com.example.demo.service;

import com.example.demo.Stock;
import com.example.demo.User;
import com.example.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class BuyService {//买入股票的Service类，卖出也用这个就行
    //本类提供：用户本金信息读取/更新，用户持有股票数量更新，股票最新价格读取
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getList(){//读用户信息表
        String sql="select balance,username from user where username='xps'";
        return(List<User>) jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs,int rowNum) throws SQLException{
                User user=new User();
                user.setBalance(rs.getInt("balance"));
                user.setUsername(rs.getString("username"));
                return user;
            }
        });
    }


    public float getBalance(){//读用户的本金信息
            List<User> user_list_temp;//用户表临时变量
            User user_temp;//用户临时变量
            user_list_temp=this.getList();//传入用户表
            user_temp=user_list_temp.get(0);//得到用户表的第一条数据
            float balance;//本金临时变量
            balance=user_temp.getBalance();//从user变量里得到本金值
            System.out.println("BALANCE="+balance);
            return balance;//将其返回
    }

    public List<Stock> getStockList(){
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
    public float getNewestprice(String stockcode){//根据股票号读最新价格
        System.out.println("STOCKCODE="+stockcode);
        List<Stock> stock_list_temp=this.getStockList();
        int i=0;
        float newest_price=0;

        for(i=0;i<stock_list_temp.size();i++) {

            Stock temp = stock_list_temp.get(i);
          //  System.out.println("#########################");
          //  System.out.println(temp.getStockcode());//工作正常
          //  System.out.println(temp.getNewest_price());//工作正常
          //  System.out.println("@@@@@@@@@@@@@@@@@@@@@");
            if (temp.getStockcode().equals(stockcode)){//Java字符串比较居然不能用==，建议炖了狗管理
                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
                newest_price=temp.getNewest_price();
                break;
            }
        }
        System.out.println("NEWEST PRICE="+newest_price);
        return newest_price;
    }
    public void setHolding(String stockcode,int count){
        //根据股票号和持有量数字更新用户持有的股票量
        String countstr = String.valueOf(count);
        String insertSql = "update stocks set holding=" + countstr + " where stockcode='"+stockcode+"';";
        System.out.println(insertSql);
        int rows = jdbcTemplate.update(insertSql);
    }

    public int getHolding(String stockcode){//获得股票持有量
        List<Stock> stock_list_temp=this.getStockList();
        int i=0;
        int holding=0;

        for(i=0;i<stock_list_temp.size();i++) {

            Stock temp = stock_list_temp.get(i);
            if (temp.getStockcode().equals(stockcode)){

                holding=temp.getHolding();
                break;
            }
        }
        System.out.println("HOLDING="+holding);
        return holding;
    }
    public void setBalance(float balance) {//更新用户的本金信息
        String balancestr = String.valueOf(balance);
        String insertSql = "update user set balance=" + balancestr + "where username='xps';";
        int rows = jdbcTemplate.update(insertSql);
    }



}
