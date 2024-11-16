package com.bcc.gestao.bluevelvet.service;

import com.bcc.gestao.bluevelvet.model.entity.Product;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import com.bcc.gestao.bluevelvet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save (ProductVO productVO){
        Product product = productVO.toEntity();
        System.out.println(productRepository.existsByNameAndBrandAndCategoryAndPrice(
                product.getName(), product.getBrand(), product.getCategory(), product.getPrice()
        ));
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public Product findByName(String name) { 
        return productRepository.findByName(name).get();
    }
  
    public void delete(int id) {
        productRepository.deleteById(id);
    }
  
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
