package com.ruhac.project_demo2.services;

import com.ruhac.project_demo2.entity.Product;
import com.ruhac.project_demo2.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> listall() {
        return productRepository.findAll();
    }

    // Get a product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

//    // Get a product by name
//    public Product getProductByName(String name) {
//        return productRepository.findProductByName(name);
//    }
//
//    // Get a product by price
//    public Product getProductPrice(float price) {
//        return productRepository.findProductByPrice(price);
//    }

    // Save or update a product
    public void save(Product product) {
        productRepository.save(product);
    }

    // Delete a product by ID
    public void delete(int id) {
        productRepository.deleteById((long) id);
    }
}
