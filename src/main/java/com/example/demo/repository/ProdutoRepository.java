package com.example.demo.repository;

import com.example.demo.model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    
}
