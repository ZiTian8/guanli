/**
 * @ClassName EmployeeController
 * @Description
 * @Author HAHA
 * @Version V1.0.0
 * @Date 2019/7/21 15:08
 */
package com.zhh.guanli.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Material {
    private Integer id;

    private String name;

    private String supplier;

    private double price;

    private double stock;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

    public Material(){}

    public Material(Integer id, String name, String supplier, double price, int stock, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.stock = stock;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
