package com.bcc.gestao.bluevelvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcc.gestao.bluevelvet.model.entity.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Optional<Product> findByName(String name);

    boolean existsByNameAndBrandAndCategoryAndPrice(String name, String brand, String category, double price);
}
