/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author HAHA
 * @Version V1.0.0
 * @Date 2019-02-28 19:59
 */
package com.zhh.guanli.service.impl;


//import com.mmall.util.RedisShardedPoolUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhh.guanli.common.ServerResponse;
import com.zhh.guanli.dao.CustomerMapper;
import com.zhh.guanli.dao.UserMapper;
import com.zhh.guanli.pojo.Customer;
import com.zhh.guanli.pojo.Material;
import com.zhh.guanli.service.ICustomerService;
import com.zhh.guanli.service.IMaterialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("iCustomerService")
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerMapper CustomerMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse getCustomerList(String query ,int pageNum, int pageSize) {
        //startPage--start
        //填充自己的sql查询逻辑
        //pageHelper-收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Customer> customerList = CustomerMapper.selectList();
        if(StringUtils.isBlank(query)){
            PageInfo pageResult = new PageInfo(customerList);
            pageResult.setList(customerList);
            return ServerResponse.createBySuccess(pageResult);
        }else {
        }
        return null;

    }
    @Override
    public ServerResponse addCustomer(Customer customer){
        int count = CustomerMapper.addCustomer(customer);
        if(count > 0){
            return ServerResponse.createBySuccess("添加产品成功");
        }else{
            return ServerResponse.createByErrorMessage("添加失败");
        }
//        int haveres = MaterialMapper.selectSame(material);
//
//        if(haveres>0){
//            Material existMaterial = MaterialMapper.getSameId(material);
//            existMaterial.setStock((int) (existMaterial.getStock()+material.getStock()));
//            int count =MaterialMapper.updateById(existMaterial);
//            if(count > 0){
//                return ServerResponse.createBySuccess("添加库存成功");
//            }else{
//                return ServerResponse.createByErrorMessage("添加失败");
//            }
//        }else{
//
//        }




    }

    @Override
    public ServerResponse getCustomer(int id) {
        Customer customer = CustomerMapper.selectById(id);
        return ServerResponse.createBySuccess(customer);
    }

    @Override
    public ServerResponse updateCustomerById(int id, Map info) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setPhone((String) info.get("phone"));
        customer.setAddress((String) info.get("address"));
        int count = CustomerMapper.updateById(customer);
        if(count > 0){
            return ServerResponse.createBySuccess("更新信息成功");
        }else{
            return ServerResponse.createByErrorMessage("更新信息失败");
        }
    }

    @Override
    public ServerResponse deleteCustomer(int id) {
        int count = CustomerMapper.deleteCustomer(id);
        if(count > 0){
            return ServerResponse.createBySuccess("删除成功");
        }else{
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }


}
