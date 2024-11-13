package com.bcc.gestao.bluevelvet.service;

import com.bcc.gestao.bluevelvet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
}
