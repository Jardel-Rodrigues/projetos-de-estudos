package com.softstream.web.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softstream.web.services.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
