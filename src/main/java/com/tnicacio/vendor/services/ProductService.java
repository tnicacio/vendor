package com.tnicacio.vendor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnicacio.vendor.entities.Product;
import com.tnicacio.vendor.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAllByOrderByNameAsc();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj =  repository.findById(id);
		return obj.get();
	}

}
