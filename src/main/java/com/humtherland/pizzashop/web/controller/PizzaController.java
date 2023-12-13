package com.humtherland.pizzashop.web.controller;

import com.humtherland.pizzashop.persistence.entity.PizzaEntity;
import com.humtherland.pizzashop.service.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
@AllArgsConstructor
public class PizzaController {

    private final PizzaService service;

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable("id") int id) {
        System.out.println("ID: " + id);
        return ResponseEntity.ok(this.service.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getByName(@PathVariable("name") String name) {
        System.out.println("NAME: " + name);
        return ResponseEntity.ok(this.service.getByName(name));
    }

    @GetMapping("/with/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable("ingredient") String ingredient) {
        System.out.println("INGREDIENTE: " + ingredient);
        return ResponseEntity.ok(this.service.getWith(ingredient));
    }

    @GetMapping("/without/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable("ingredient") String ingredient) {
        System.out.println("INGREDIENTE: " + ingredient);
        return ResponseEntity.ok(this.service.getWithout(ingredient));
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getById() {
        return ResponseEntity.ok(this.service.getAvailable());
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.service.save(pizza));
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() == null || !this.service.exists(pizza.getIdPizza())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(this.service.save(pizza));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if (!this.service.exists(id)) {
            return ResponseEntity.badRequest().build();
        }
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

}
