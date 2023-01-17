package com.example.mongodbcrud.repo;

import com.example.mongodbcrud.MongoDbCrudApplication;

import com.example.mongodbcrud.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
}
