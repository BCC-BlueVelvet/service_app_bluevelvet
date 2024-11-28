package com.bcc.gestao.bluevelvet.rest;

import com.bcc.gestao.bluevelvet.model.entity.Product;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import com.bcc.gestao.bluevelvet.rest.swagger.ProductRestControllerSwagger;
import com.bcc.gestao.bluevelvet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductRestController implements ProductRestControllerSwagger {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<Product> save (@RequestBody ProductVO productVO) {
       Product product = productService.save(productVO);
        return ResponseEntity.status(201).body(product);
    }

    @Override
    public ResponseEntity<List<Product>> find(@RequestParam String name) {
        List<Product> products = productService.findByName(name);
        return ResponseEntity.status(200).body(products);
    }

    @Override
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Product product = productService.findById(id);
        return ResponseEntity.status(200).body(product);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable int id) {
        productService.delete(id);  
        return ResponseEntity.status(204).build();  
    }

    @Override
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody ProductVO productVO) {
         Product updatedProduct = productService.update(id, productVO);
         return ResponseEntity.status(201).body(updatedProduct);
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.status(200).body(products);
    }
}
