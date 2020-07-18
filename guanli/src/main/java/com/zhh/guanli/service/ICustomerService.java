package com.zhh.guanli.service;


import com.zhh.guanli.common.ServerResponse;
import com.zhh.guanli.pojo.Customer;

import java.util.Map;

public interface ICustomerService {

    ServerResponse getCustomerList(String query, int pageNum, int pageSize);

    ServerResponse addCustomer(Customer customer);

    ServerResponse getCustomer(int id);

    ServerResponse updateCustomerById(int id, Map info);

    ServerResponse deleteCustomer(int id);
}
