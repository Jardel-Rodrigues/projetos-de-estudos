package com.softstrem.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softstrem.dscommerce.entities.Category;

@Repository
public interface CategotyRepository extends JpaRepository<Category, Long> {

}
