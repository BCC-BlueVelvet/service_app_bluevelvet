package com.bcc.gestao.bluevelvet.rest;

import com.bcc.gestao.bluevelvet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

    @Autowired
    private ProductService productService;
}
