package com.myshop.repositories;

import com.myshop.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findByDescription(String description);
    List<Product> findAllBy();
    Product findById(long id);
}
