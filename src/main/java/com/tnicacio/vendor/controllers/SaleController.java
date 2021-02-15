package com.tnicacio.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnicacio.vendor.entities.Sale;
import com.tnicacio.vendor.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
		List<Sale> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = "/pending")
	public ResponseEntity<List<Sale>> findAllPending() {
		List<Sale> list = service.findAllPending();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sale> findSaleById(@PathVariable Long id) {
		Sale obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
