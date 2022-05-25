package com.example.customerjpa.controller;

import com.example.customerjpa.entity.CustomerDetail;
import com.example.customerjpa.service.CustomerDetailService;
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
public class CustomerDetailController {

    @Autowired
    private CustomerDetailService customerDetailService;

    @GetMapping("/{id}/detail")
    public ResponseEntity<?> getCustomerDetailById(@PathVariable int id) {
        CustomerDetail customerDetail = customerDetailService.findByCustomerDetailId(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDetail);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addCustomerDetail(@PathVariable int id, @RequestBody CustomerDetail customerDetail) {
        CustomerDetail _customerDetail = customerDetailService.addCustomerDetail(id, customerDetail);
        return ResponseEntity.status(HttpStatus.OK).body(_customerDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomerDetail(@PathVariable int id, @RequestBody CustomerDetail customerDetail) {
        CustomerDetail _customerDetail = customerDetailService.updateCustomerDetail(id, customerDetail);
        return ResponseEntity.status(HttpStatus.OK).body(_customerDetail);
    }

    @DeleteMapping("/{id}/detail")
    public ResponseEntity<?> removeCustomerDetail(@PathVariable int id) {
        customerDetailService.deleleteCustomerDetailById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}