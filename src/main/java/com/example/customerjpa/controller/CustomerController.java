package com.example.customerjpa.controller;

import com.example.customerjpa.entity.Customer;
import com.example.customerjpa.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByCustomerId(@PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @GetMapping("")
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @PostMapping("")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Customer tempCustomer = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(tempCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByCustomerId(@PathVariable(value = "id") int id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        Customer tempCustomer = customerService.updateCustomer(customer.getId(), customer.getName(), customer.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(tempCustomer);
    }

}
