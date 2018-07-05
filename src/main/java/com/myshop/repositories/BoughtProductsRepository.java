package com.myshop.repositories;

import com.myshop.Model.BoughtProduct;
import javassist.expr.Expr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoughtProductsRepository extends JpaRepository<BoughtProduct, Long> {
    List<BoughtProduct> findAll();
    List<BoughtProduct> findBoughtProductsByUserId(long userId);
}
