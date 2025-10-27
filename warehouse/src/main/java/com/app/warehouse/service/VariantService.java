package com.app.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.warehouse.entity.Item;
import com.app.warehouse.entity.Variant;
import com.app.warehouse.exception.OutOfStockException;
import com.app.warehouse.repository.ItemRepository;
import com.app.warehouse.repository.VariantRepository;

import jakarta.transaction.Transactional;

@Service
public class VariantService {

    private final VariantRepository variantRepository;
    private final ItemRepository itemRepository;

    public VariantService(VariantRepository variantRepository, ItemRepository itemRepository) {
        this.variantRepository = variantRepository;
        this.itemRepository = itemRepository;
    }

    public List<Variant> getByItem(Long itemId) {
        return variantRepository.findByItemId(itemId);
    }

    public Variant create(Long itemId, Variant variant) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new com.app.warehouse.exception.NotFoundException("Item not found"));
        variant.setItem(item);
        return variantRepository.save(variant);
    }

    public Variant update(Long id, Variant updated) {
        Variant v = variantRepository.findById(id)
                .orElseThrow(() -> new com.app.warehouse.exception.NotFoundException("Variant not found"));
        v.setColor(updated.getColor());
        v.setSize(updated.getSize());
        v.setPrice(updated.getPrice());
        v.setStock(updated.getStock());
        return variantRepository.save(v);
    }

    @Transactional
    public Variant sell(Long id, int quantity) {
        Variant v = variantRepository.findById(id)
                .orElseThrow(() -> new com.app.warehouse.exception.NotFoundException("Variant not found"));
        if (v.getStock() < quantity)
            throw new OutOfStockException("Not enough stock available");
        v.setStock(v.getStock() - quantity);
        return v;
    }

    public void delete(Long id) {
        variantRepository.deleteById(id);
    }
    
}