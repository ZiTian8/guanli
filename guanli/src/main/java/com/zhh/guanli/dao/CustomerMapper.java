package com.zhh.guanli.dao;


import com.zhh.guanli.pojo.Customer;
import com.zhh.guanli.pojo.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {


    List<Customer> selectList();

    int addCustomer(Customer customer);


    int updateById(Customer customer);

    Customer selectById(int id);


    int deleteCustomer(int id);
}
