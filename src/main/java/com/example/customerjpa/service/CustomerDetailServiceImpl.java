package com.example.customerjpa.service;

import com.example.customerjpa.entity.CustomerDetail;
import com.example.customerjpa.exception.NotFoundException;
import com.example.customerjpa.repository.CustomerDetailRepository;
import com.example.customerjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerDetailServiceImpl implements CustomerDetailService{

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDetail addCustomerDetail(int id, CustomerDetail customerDetail) {
        return customerRepository.findById(id)
            .map(customer -> {
                customerDetail.setCustomer(customer);
                return customerDetailRepository.save(customerDetail);
            })
            .orElseThrow(() -> new NotFoundException("Cannot find Customer ID = " + id));
    }

    @Override
    public void deleteCustomerDetailById(int id) {
        if (!customerRepository.existsById(id)) {
            throw new NotFoundException("Cannot find Customer ID = " + id);
        }
        customerDetailRepository.deleteByCustomerId(id);
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
