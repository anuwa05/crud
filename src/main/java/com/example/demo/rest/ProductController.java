package com.example.demo.rest;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    private ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }


    @GetMapping("/product/{productid}")
    private ResponseEntity<Product> getProduct(@PathVariable("productid") int productid)
    {
        return new ResponseEntity<>(productService.getProductById(productid), HttpStatus.OK);
    }

    @DeleteMapping("/product/{productid}")
    private void deleteBook(@PathVariable("productid") int productid)
    {
        productService.delete(productid);
    }

    @PostMapping("/product")
    private ResponseEntity<Integer> saveBook(@RequestBody Product product)
    {
        productService.save(product);
        return new ResponseEntity<>(product.getProductId(), HttpStatus.CREATED);
    }

    @PutMapping("/product")
    private ResponseEntity<Product> update(@RequestBody Product product)
    {
        productService.update(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
