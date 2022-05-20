package com.example.customerjpa.repository;

import com.example.customerjpa.entity.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer save(Customer customer);

    Optional<Customer> findById(Integer id);

    List<Customer> findAll();

    void deleteById(Integer id);

    @Modifying
    @Query(value = "update customer c set c.customer_name = ?1, c.customer_email = ?2 "
        + "where c.customer_id = ?3", nativeQuery = true)
    void update(String name, String email, int id);
}
