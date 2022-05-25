package com.example.customerjpa.repository;

import com.example.customerjpa.entity.CustomerDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailRepository extends CrudRepository<CustomerDetail, Integer> {
}
