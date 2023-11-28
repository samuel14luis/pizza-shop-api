package com.humtherland.pizzashop.persistence.repository;

import com.humtherland.pizzashop.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

}
