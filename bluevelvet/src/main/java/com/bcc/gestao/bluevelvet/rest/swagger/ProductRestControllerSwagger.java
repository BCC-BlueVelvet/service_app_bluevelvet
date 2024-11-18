package com.bcc.gestao.bluevelvet.rest.swagger;

import com.bcc.gestao.bluevelvet.model.entity.Product;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1")
public interface ProductRestControllerSwagger {

    @PostMapping("/products")
    public ResponseEntity<Product> save (@RequestBody ProductVO productVO);

    @GetMapping("/products/{name}")
    public ResponseEntity<List<Product>> find(@PathVariable String name);

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable int id);

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody ProductVO productVO);

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll();
}
