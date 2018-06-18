package com.example.demo;

public class BuyResult {//这个类是专门用于处理交易结果显示的
    String type;//交易类型：买入、卖出
    String stockcode;//股票号码
    float money;//交易金额
    float price;//交易单价
    int count;//交易股数
    String result;//交易结果（提示信息字符串）
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



}
