package com.bcc.gestao.bluevelvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcc.gestao.bluevelvet.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByName(String name);
}
