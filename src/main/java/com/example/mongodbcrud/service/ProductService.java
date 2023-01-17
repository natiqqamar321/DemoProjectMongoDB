package com.example.mongodbcrud.service;

import com.example.mongodbcrud.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
         void save(Product product);
         void delete(String id);
         void deleteAll();
         List<Product> getAll();
         Product getProductById(String id);

}
