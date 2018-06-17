package com.example.demo;

public class Stock {
    private String stockcode;
    private String stockname;
    private int holding;

    public String getStockcode() {

        return stockcode;
    }

    public void setStockcode(String stockcode) {

        this.stockcode = stockcode;
    }

    public String getStockname() {

        return stockname;
    }

    public void setStockname(String stockname) {

        this.stockname = stockname;
    }

    public int getHolding(){
        return holding;
    }

    public void setHolding(int holding){
        this.holding=holding;
    }
}
