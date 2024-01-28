package com.devsuperior.uri2621.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
