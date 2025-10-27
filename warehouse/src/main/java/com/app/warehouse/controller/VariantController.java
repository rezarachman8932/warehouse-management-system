package com.app.warehouse.controller;

import org.springframework.web.bind.annotation.*;

import com.app.warehouse.entity.Variant;
import com.app.warehouse.service.VariantService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VariantController {

    private final VariantService service;

    public VariantController(VariantService service) {
        this.service = service;
    }

    @GetMapping("/items/{itemId}/variants")
    public List<Variant> getByItem(@PathVariable Long itemId) {
        return service.getByItem(itemId);
    }

    @PostMapping("/items/{itemId}/variants")
    public Variant create(@PathVariable Long itemId, @RequestBody Variant variant) {
        return service.create(itemId, variant);
    }

    @PutMapping("/variants/{id}")
    public Variant update(@PathVariable Long id, @RequestBody Variant variant) {
        return service.update(id, variant);
    }

    @DeleteMapping("/variants/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/variants/{id}/sell")
    public Variant sell(@PathVariable Long id, @RequestParam int quantity) {
        return service.sell(id, quantity);
    }
    
}

