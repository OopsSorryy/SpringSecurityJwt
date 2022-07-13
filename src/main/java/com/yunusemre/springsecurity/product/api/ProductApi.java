package com.yunusemre.springsecurity.product.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {


    ProductRepository productRepository;

    @Autowired
    public ProductApi(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/getAll")
    public List<Product> list(){
        return productRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Product> create (@RequestBody @Valid Product product){
         Product saveProduct = productRepository.save(product);
         return ResponseEntity.ok(saveProduct);
    }
}
