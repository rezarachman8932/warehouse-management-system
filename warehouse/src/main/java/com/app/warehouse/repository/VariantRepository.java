package com.app.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.warehouse.entity.Variant;

public interface VariantRepository extends JpaRepository<Variant, Long> {
    List<Variant> findByItemId(Long itemId);
}