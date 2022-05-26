package com.example.customerjpa.service;

import com.example.customerjpa.entity.Order;
import com.example.customerjpa.exception.NotFoundException;
import com.example.customerjpa.repository.CustomerRepository;
import com.example.customerjpa.repository.OrderRepository;
import com.example.customerjpa.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Order findByOrderId(int orderId) {
        return orderRepository.findById(orderId)
            .orElseThrow(() -> new NotFoundException("Cannot find Order ID = " + orderId));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findAllByCustomerId(int customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new NotFoundException("Cannot find Customer Id = " + customerId);
        }
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Order> findOrdersByProductId(int productId) {
        if(!productRepository.existsById(productId)) {
            throw new NotFoundException("Cannot find Product Id = " + productId);
        }
        return orderRepository.findOrderByProductId(productId);
    }

    @Override
    public Order addOrder(int customerId, Order order) {
        return customerRepository.findById(customerId)
            .map(customer -> {
                order.setCustomer(customer);
                return orderRepository.save(order);
            })
            .orElseThrow(() -> new NotFoundException("Cannot find Customer Id = " + customerId));
    }

    @Override
    public void deleteByOrderId(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void deleteAllByCustomerId(int customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new NotFoundException("Cannot find Customer Id = " + customerId);
        }
        orderRepository.deleteByCustomerId(customerId);
    }

    @Override
    public Order updateOrder(int orderId, Order order) {
        Order _order = orderRepository.findById(orderId)
            .orElseThrow(() -> new NotFoundException("Cannot find Order ID = " + orderId));

        _order.setName(order.getName());
        _order.setDate(order.getDate());

        return orderRepository.save(_order);
    }

    @Override
    public Order deleteProductFromOrder(int orderId, int productId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new NotFoundException("Cannot find Order ID = " + orderId));

        order.removeProduct(productId);
        return orderRepository.save(order);
    }

}
