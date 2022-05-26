package com.example.customerjpa.repository;

import com.example.customerjpa.entity.CustomerDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailRepository extends CrudRepository<CustomerDetail, Integer> {

    @Modifying
    @Query(value = "delete from customer_detail where customer_id = ?1", nativeQuery = true)
    void deleteByCustomerId(int customerId);

}
