package com.example.customerjpa.service;

import com.example.customerjpa.entity.Customer;
import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> getCustomers();

    boolean deleteCustomer(int id);

    Customer updateCustomer(int id, String name, String email);
}
