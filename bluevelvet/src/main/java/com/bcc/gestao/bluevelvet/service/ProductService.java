package com.bcc.gestao.bluevelvet.service;

import com.bcc.gestao.bluevelvet.exception.ProductNotFoundException;
import com.bcc.gestao.bluevelvet.model.entity.Product;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import com.bcc.gestao.bluevelvet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save (ProductVO productVO){
        Product product = productVO.toEntity();
        return productRepository.save(product);
    }

    public Product update(int id, ProductVO productVO) {
        Product product = productVO.toEntity();
        Optional<Product> dbProduct = productRepository.findById(id);
        if(dbProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not exists to update.");
        }
        product.setId(id);
        return productRepository.save(product);
    }

    public List<Product> findByName(String name) {
        List<Product> products = productRepository.findByName(name);
        if(products.isEmpty()) {
            throw new ProductNotFoundException(name + " not exists.");
        }
        return products;
    }

    public Product findById(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found.");
        }
        return optionalProduct.get();
    }
  
    public void delete(int id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new ProductNotFoundException("Product already not exists.");
        }
        productRepository.deleteById(id);
    }
  
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
