package com.tnicacio.vendor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnicacio.vendor.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findAllByOrderByNameAsc();
}
