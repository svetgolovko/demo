package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        System.out.println("getAllProducts");
        return (List<Product>) repository.findAll();
    }
    @PostMapping(value = "/products")
    void addProduct(@RequestBody Product product) {
        System.out.println("addProduct "+product.getBarcode());
        Product _product = repository.save(product);
    }
    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable("id") long id) {
        Optional<Product> productData = repository.findById(id);
        return productData;
    }
}
