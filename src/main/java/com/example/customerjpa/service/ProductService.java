package com.example.customerjpa.service;

import com.example.customerjpa.entity.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> findAll();

    Product findProductById(int productId);

    void deleteProductById(int productId);

    Product updateProduct(int productId, Product product);

    void addProductToOrder(int orderId, int productId);

    List<Product> findProductsByOrderId(int orderId);



}
