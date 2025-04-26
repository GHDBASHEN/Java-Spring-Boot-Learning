package com.ruhac.project_demo2.repository;

import com.ruhac.project_demo2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


//    Product findProductByName(String name);
//
//    Product findProductByPrice(float price);
}
