package com.sajal.springcrud.repository;

import com.sajal.springcrud.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product,Integer> {
    List<Product> findByNameContaining(String name);
}
