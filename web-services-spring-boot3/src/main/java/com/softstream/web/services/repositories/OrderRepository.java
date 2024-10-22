package com.softstream.web.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softstream.web.services.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
