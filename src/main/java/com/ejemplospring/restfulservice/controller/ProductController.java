package com.ejemplospring.restfulservice.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejemplospring.restfulservice.controller.model.ProductID;
import com.ejemplospring.restfulservice.model.Product;

@RestController
public class ProductController {

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product){
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product("1",
                "Product1",
                new BigDecimal("258.53")));
        result.add(new Product("2",
                "Product2",
                new BigDecimal("48.99")));
        result.add(new Product("3",
                "Product3",
                new BigDecimal("800.20")));
        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product("888",
                "Retorna un solo producto",
                new BigDecimal("444.45"));
    }

    @PatchMapping("/product")
    public void patchProduct(@RequestBody final Product product){
        System.out.println(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id){
        System.out.println(id);
    }
}
