package com.example.freemarkerdemo.entity;

public class Order {
    private String goodsName;

    private String num;

    private String packageName;

    private String orderPkgNum;

    private String createTime;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getOrderPkgNum() {
        return orderPkgNum;
    }

    public void setOrderPkgNum(String orderPkgNum) {
        this.orderPkgNum = orderPkgNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
