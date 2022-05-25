package com.example.customerjpa.service;

import com.example.customerjpa.entity.CustomerDetail;

public interface CustomerDetailService {

    CustomerDetail addCustomerDetail(int id, CustomerDetail customerDetail);

    void deleleteCustomerDetailById(int id);

    CustomerDetail updateCustomerDetail(int id, CustomerDetail customerDetail);

    CustomerDetail findByCustomerDetailId(int id);

}
