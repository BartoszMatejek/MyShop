package com.myshop.repositories;

import com.myshop.model.BoughtProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoughtProductsRepository extends JpaRepository<BoughtProduct, Long> {
    List<BoughtProduct> findAll();
    List<BoughtProduct> findBoughtProductsByUserId(long userId);
}
