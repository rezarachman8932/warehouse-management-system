package com.app.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.warehouse.entity.Item;
import com.app.warehouse.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item getById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new com.app.warehouse.exception.NotFoundException("Item not found"));
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Long id, Item item) {
        Item existing = getById(id);
        existing.setName(item.getName());
        existing.setDescription(item.getDescription());
        return itemRepository.save(existing);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
    
}