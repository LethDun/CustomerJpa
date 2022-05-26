package com.example.customerjpa.controller;

import com.example.customerjpa.entity.Order;
import com.example.customerjpa.service.OrderService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/customer/{customerId}/order")
    public ResponseEntity<?> addOrder(@PathVariable(value = "customerId") int customerId, @RequestBody Order order) {
         Order _order = orderService.addOrder(customerId, order);
         return ResponseEntity.status(HttpStatus.OK).body(_order);
    }

    @GetMapping("/order")
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable(value = "orderId") int orderId) {
        Order order = orderService.findByOrderId(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @GetMapping("/customer/{customerId}/order")
    public ResponseEntity<?> getOrdersByCustomerId(@PathVariable(value = "customerId") int customerId) {
        List<Order> orders = orderService.findAllByCustomerId(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<?> deleteOrderById(@PathVariable(value = "orderId") int orderId) {
        orderService.deleteByOrderId(orderId);
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted");
    }

    @DeleteMapping("/customer/{customerId}/order")
    public ResponseEntity<?> deleteAllByCustomerId(@PathVariable(value = "customerId") int customerId) {
        orderService.deleteAllByCustomerId(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("Orders deleted");
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable(value = "orderId") int orderId, @RequestBody Order order) {
        Order _order = orderService.updateOrder(orderId, order);
        return ResponseEntity.status(HttpStatus.OK).body(_order);
    }

    @GetMapping("/product/{productId}/order")
    public ResponseEntity<?> getOrdersByproductId(@PathVariable(value = "productId") int productId) {
        List<Order> orders = orderService.findOrdersByProductId(productId);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @DeleteMapping("/order/{orderId}/{productId}")
    public ResponseEntity<?> deleteProductFromOrder(@PathVariable(value = "orderId") int orderId,
        @PathVariable(value = "productId") int productId) {

        Order order = orderService.deleteProductFromOrder(orderId, productId);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

}
