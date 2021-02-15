package com.tnicacio.vendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnicacio.vendor.entities.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{

}
