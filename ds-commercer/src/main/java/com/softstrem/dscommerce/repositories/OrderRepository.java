package com.softstrem.dscommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.softstrem.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
