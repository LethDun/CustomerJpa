package com.example.customerjpa.repository;

import com.example.customerjpa.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAll();

    List<Order> findByCustomerId(int customerId);

    void deleteByCustomerId(int customerId);

    @Modifying
    @Query(value =
        "select o.order_id, o.order_name, o.order_date, o.customer_id from `order` o "
            + "inner join order_product op "
            + "on o.order_id = op.order_id "
            + "where op.product_id = ?1",
        nativeQuery = true)
    List<Order> findOrderByProductId(int productId);

    @Modifying
    @Query(value =
        "delete from order_product op where op.order_id = ?1",
        nativeQuery = true)
    Order deleteAllProducts(int orderId);

}
