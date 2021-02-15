package com.tnicacio.vendor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnicacio.vendor.entities.Sale;
import com.tnicacio.vendor.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findAll() {
		return repository.findSales();
	}
	
	public List<Sale> findAllPending() {
		return repository.findAllPending();
	}
	
	public Sale findById(Long id) {
		Optional<Sale> obj =  repository.findSaleById(id);
		return obj.get();
	}

}
