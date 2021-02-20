package com.example.freemarkerdemo.entity;

import java.util.List;

/**
 * 已支付订单
 */
public class PayedOrder {
    private Integer no;
    private String orderNo;
    private String createTime;
    private String orderSource;
    private String custName;
    private String custNo;
    private String province;
    private String platform;

    private String goodsName;
    private String packageName;
    private String orderCount;
    private List<GoodsInfo> goodsInfoList;
    private String goodsInfoSize;

    private String orderBill;

    private String payStatus;
    private String payTime;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfo> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public String getGoodsInfoSize() {
        return goodsInfoSize;
    }

    public void setGoodsInfoSize(String goodsInfoSize) {
        this.goodsInfoSize = goodsInfoSize;
    }

    public String getOrderBill() {
        return orderBill;
    }

    public void setOrderBill(String orderBill) {
        this.orderBill = orderBill;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(String orderCount) {
        this.orderCount = orderCount;
    }
}
