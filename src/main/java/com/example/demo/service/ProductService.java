package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.exception.ProductCreateException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        products.addAll(productRepository.findAll());
        return products;
    }

    public Product getProductById(int productId){
        if(productRepository.findById(productId).isPresent()){
            return productRepository.findById(productId).get();
        }
        throw new ProductNotFoundException("Product not Found");
    }

    public void save(Product product)
    {
        if(ObjectUtils.isEmpty(product.getProductName())){
            throw new ProductCreateException("Product Name Cannot empty");
        }
        if(!ObjectUtils.isEmpty(product.getProductId())){
            throw new ProductCreateException("Product Id Cannot have Value When Create");
        }
        try{
            productRepository.save(product);
        } catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    public void delete(int id)
    {
        try{
            productRepository.deleteById(id);
        } catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    public void update(Product product)
    {
        if(ObjectUtils.isEmpty(product.getProductId())){
            throw new ProductCreateException("Product Id Cannot empty When Update");
        }
        try{
            productRepository.save(product);
        } catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

}
