package com.tnicacio.vendor.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tnicacio.vendor.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT DISTINCT obj from Sale obj "
			+ "JOIN FETCH obj.items ORDER BY obj.date ASC")
	List<Sale> findSales();
	
	@Query("SELECT DISTINCT obj from Sale obj "
			+ "JOIN FETCH obj.items " 
			+ "WHERE obj.id = ?1 "
			+ "ORDER BY obj.date ASC")
	Optional<Sale> findSaleById(Long id);
	
	@Query("SELECT DISTINCT obj from Sale obj "
			+ "JOIN FETCH obj.items " 
			+ "WHERE obj.status = 0 "
			+ "ORDER BY obj.date ASC")
	List<Sale> findAllPending();
	
}
