package com.humtherland.pizzashop.service;

import com.humtherland.pizzashop.persistence.entity.PizzaEntity;
import com.humtherland.pizzashop.persistence.repository.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaService {

    private final JdbcTemplate jdbcTemplate;
    private final PizzaRepository repository;

    public List<PizzaEntity> getAll() {
        //return this.jdbcTemplate.query("SELECT * FROM pizza;", new BeanPropertyRowMapper<>(PizzaEntity.class));
        return this.repository.findAll();
    }

    public List<PizzaEntity> getAvailable() {
        return this.repository.findAllByAvailableTrueOrderByPrice();
    }

    public PizzaEntity getByName(String name) {
        return this.repository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getWith(String ingredient) {
        return this.repository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getWithout(String ingredient) {
        return this.repository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public PizzaEntity getById(int id) {
        //return this.jdbcTemplate.queryForObject("SELECT * FROM pizza WHERE id_pizza = ?;", new Object[]{id}, new BeanPropertyRowMapper<>(PizzaEntity.class));
        return this.repository.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza) {
        return this.repository.save(pizza);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }

    public boolean exists(int id) {
        return this.repository.existsById(id);
    }

}
