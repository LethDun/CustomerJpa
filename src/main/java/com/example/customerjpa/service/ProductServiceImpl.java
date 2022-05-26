package com.example.customerjpa.service;

import com.example.customerjpa.entity.Order;
import com.example.customerjpa.entity.Product;
import com.example.customerjpa.exception.NotFoundException;
import com.example.customerjpa.repository.OrderRepository;
import com.example.customerjpa.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(int productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new NotFoundException("Cannot find Product Id = " + productId));
    }

    @Override
    public void deleteProductById(int productId) {
        if (!productRepository.existsById(productId)) {
            throw  new NotFoundException("Cannot find Product Id = " + productId);
        }
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product _product = productRepository.findById(productId)
            .orElseThrow(() -> new NotFoundException("Cannot find Product Id = " + productId));

        _product.setName(product.getName());
        _product.setPrice(product.getPrice());

        return productRepository.save(_product);
    }

    @Override
    public void addProductToOrder(int orderId, int productId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new NotFoundException("Cannot find Order Id = " + orderId));
        Product product = this.findProductById(productId);

        order.addProduct(product);
        orderRepository.save(order);
    }

    @Override
    public List<Product> findProductsByOrderId(int orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new NotFoundException("Cannot find Order Id = " + orderId);
        }
        return productRepository.findProductByOrderId(orderId);
    }

}
