package com.humtherland.pizzashop.persistence.repository;

import com.humtherland.pizzashop.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {

}
