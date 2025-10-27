package com.app.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.warehouse.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}