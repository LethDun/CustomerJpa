package com.example.customerjpa.service;

import com.example.customerjpa.entity.CustomerDetail;
import com.example.customerjpa.exception.NotFoundException;
import com.example.customerjpa.repository.CustomerDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailServiceImpl implements CustomerDetailService{

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @Override
    public CustomerDetail addCustomerDetail(int id, CustomerDetail customerDetail) {
        CustomerDetail _customerDetail = new CustomerDetail();
        _customerDetail.setId(id);
        _customerDetail.setAge(customerDetail.getAge());
        _customerDetail.setAddress(customerDetail.getAddress());
        return customerDetailRepository.save(_customerDetail);
    }

    @Override
    public void deleleteCustomerDetailById(int id) {
        customerDetailRepository.deleteById(id);
    }

    @Override
    public CustomerDetail updateCustomerDetail(int id, CustomerDetail customerDetail) {
        CustomerDetail _customerDetail = findByCustomerDetailId(id);

        _customerDetail.setAge(customerDetail.getAge());
        _customerDetail.setAddress(customerDetail.getAddress());

        return customerDetailRepository.save(_customerDetail);
    }

    @Override
    public CustomerDetail findByCustomerDetailId(int id) {
        return customerDetailRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Customer Detail ID not found: ID = " + id));
    }
}
