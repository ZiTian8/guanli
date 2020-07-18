/**
 * @ClassName User
 * @Description
 * @Author HAHA
 * @Version V1.0.0
 * @Date 2019/7/20 16:24
 */
package com.zhh.guanli.pojo;



import java.io.Serializable;
import java.util.Date;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Customer implements Serializable {
    private Integer id;

    private String name;

    private String phone;

    private String address;

    private Date createTime;

    private Date updateTime;

    public Customer() {
    }

    public Customer(Integer id, String name, String phone, String address, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
