package com.example.customerjpa.service;

import com.example.customerjpa.entity.Customer;
import com.example.customerjpa.exception.NotFoundException;
import com.example.customerjpa.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Customer Id not found: ID = " + id));
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(int id, String name, String email) {
        customerRepository.update(name, email, id);
        return getCustomerById(id);
    }
}
