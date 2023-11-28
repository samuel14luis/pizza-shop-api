package com.humtherland.pizzashop.service;

import com.humtherland.pizzashop.persistence.entity.OrderEntity;
import com.humtherland.pizzashop.persistence.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<OrderEntity> getAll() {
        return this.repository.findAll();
    }

}
