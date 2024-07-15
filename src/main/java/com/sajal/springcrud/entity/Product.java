package com.sajal.springcrud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



@Table("products")
public record Product(@Id Integer id, String name, String description, Integer price) {
}
