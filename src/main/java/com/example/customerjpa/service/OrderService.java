package com.example.customerjpa.service;

import com.example.customerjpa.entity.Order;
import java.util.List;

public interface OrderService {

    Order findByOrderId(int orderId);

    List<Order> findAll();

    List<Order> findAllByCustomerId(int customerId);

    List<Order> findOrdersByProductId(int productId);

    Order addOrder(int customerId, Order order);

    void deleteByOrderId(int orderId);

    void deleteAllByCustomerId(int customerId);

    Order updateOrder(int orderId, Order order);

    Order deleteProductFromOrder(int orderId, int productId);

}
