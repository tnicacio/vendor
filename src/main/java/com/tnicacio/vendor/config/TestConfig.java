package com.tnicacio.vendor.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tnicacio.vendor.entities.Payment;
import com.tnicacio.vendor.entities.Product;
import com.tnicacio.vendor.entities.Sale;
import com.tnicacio.vendor.entities.SaleItem;
import com.tnicacio.vendor.entities.enums.SaleStatus;
import com.tnicacio.vendor.repositories.ProductRepository;
import com.tnicacio.vendor.repositories.SaleItemRepository;
import com.tnicacio.vendor.repositories.SaleRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SaleItemRepository saleItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	Product p1 = new Product(null, "Pizza", "An excellent choice. But Does not come with ketchup", 12.50, 113, null);
	Product p2 = new Product(null, "Cheese", "Good, but quite expensive", 45.00, 400, null);
	Product p3 = new Product(null, "French fries", "Hmmm... fries", 45.00, 250, null);
	productRepository.saveAll(Arrays.asList(p1,p2,p3));
	
	Sale s1 = new Sale(null, Instant.parse("2019-06-20T19:53:07Z"), false, SaleStatus.PENDING);
	Sale s2 = new Sale(null, Instant.parse("2019-08-12T20:12:14Z"), false, SaleStatus.DELIVERED);
	saleRepository.saveAll(Arrays.asList(s1,s2));
	
	SaleItem si1 = new SaleItem(s1, p1, 3, p1.getPrice());
	SaleItem si2 = new SaleItem(s1, p2, 1, p2.getPrice());
	SaleItem si3 = new SaleItem(s2, p3, 2, p3.getPrice());
	saleItemRepository.saveAll(Arrays.asList(si1,si2,si3));
	
	Payment pay1 = new Payment(null,Instant.parse("2019-08-12T20:12:14Z"), Instant.parse("2019-08-12T21:10:02Z"), s2);
	s2.setPayment(pay1);
	saleRepository.save(s2);
	
	}

}
