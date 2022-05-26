package com.example.customerjpa.repository;

import com.example.customerjpa.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    @Modifying
    @Query(value =
        "select p.product_id, p.product_name, p.product_price from product p "
            + "inner join order_product op "
            + "on p.product_id = op.product_id "
            + "where op.order_id = ?1",
        nativeQuery = true)
    List<Product> findProductByOrderId(int orderId);

}
