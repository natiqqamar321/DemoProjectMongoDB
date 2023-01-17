package com.example.mongodbcrud.service;

import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.repo.ProductRepository;
import org.apache.taglibs.standard.lang.jstl.GreaterThanOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

      @Autowired
     private ProductRepository productRepository;
    @Override
    public void save(Product product) {
        System.out.println("Inside save method of Product Service Impl");
        this.productRepository.save(product);

    }

    @Override
    public void delete(String id) {
         this.productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.productRepository.deleteAll();
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> productbyId = this.productRepository.findById(id);
        Product product = null;
        if (productbyId.isPresent()){
            product = productbyId.get();
        }
        return product;
    }


}
