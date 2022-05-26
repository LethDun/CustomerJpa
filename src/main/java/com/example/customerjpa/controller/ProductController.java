package com.example.customerjpa.controller;

import com.example.customerjpa.entity.Product;
import com.example.customerjpa.service.ProductService;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        Product _product = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(_product);
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable(value="productId") int productId){
        Product product = productService.findProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable(value="productId") int productId){
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable(value = "productId") int productId, @RequestBody Product product) {
        Product _product = productService.updateProduct(productId, product);
        return ResponseEntity.status(HttpStatus.OK).body(_product);
    }

    @PostMapping("/order/{orderId}/{productId}")
    public ResponseEntity<?> addProductToOrder(@PathVariable(value = "orderId") int orderId,
        @PathVariable(value = "productId") int productId) {
        productService.addProductToOrder(orderId, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/order/{orderId}/product")
    public ResponseEntity<?> getProductsFromOrder(@PathVariable(value="orderId") int orderId){
        List<Product> products = productService.findProductsByOrderId(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
