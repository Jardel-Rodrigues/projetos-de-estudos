package com.softstrem.dscommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.softstrem.dscommerce.entities.OrderItem;
import com.softstrem.dscommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
