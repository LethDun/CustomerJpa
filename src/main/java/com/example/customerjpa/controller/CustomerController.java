package com.example.customerjpa.controller;

import com.example.customerjpa.entity.Customer;
import com.example.customerjpa.exception.ErrorRespone;
import com.example.customerjpa.exception.NotFoundException;
import com.example.customerjpa.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/id")
    public Customer findById(@RequestParam(value = "id") int id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable(value = "id") int id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping("")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer.getId(), customer.getName(), customer.getEmail());
    }

}
