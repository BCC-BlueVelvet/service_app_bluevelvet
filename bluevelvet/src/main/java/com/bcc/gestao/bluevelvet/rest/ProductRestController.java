package com.bcc.gestao.bluevelvet.rest;

import com.bcc.gestao.bluevelvet.model.entity.Product;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import com.bcc.gestao.bluevelvet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> save (@RequestBody ProductVO productVO) {
       Product product = productService.save(productVO);
        return ResponseEntity.status(201).body(product);
    }

    @GetMapping("/products/{name}") 
    public ResponseEntity<List<Product>> find(@PathVariable String name) {
        List<Product> products = productService.findByName(name);
        return ResponseEntity.status(200).body(products);
    }
      
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        productService.delete(id);  
        return ResponseEntity.status(204).build();  
    }
   
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody ProductVO productVO) {
         Product updatedProduct = productService.update(id, productVO);
         return ResponseEntity.status(201).body(updatedProduct);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.status(200).body(products);
    }
}
