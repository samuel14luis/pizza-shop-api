package com.humtherland.pizzashop.web.controller;

import com.humtherland.pizzashop.persistence.entity.OrderEntity;
import com.humtherland.pizzashop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

}
