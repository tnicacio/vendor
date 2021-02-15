package com.tnicacio.vendor.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;

	@Column(columnDefinition = "DECIMAL(14,4)")
	private Double price;
	
	private Integer stockQuantity;
	private String imgUri;
	
	@OneToMany(mappedBy = "id.product")
	private Set<SaleItem> items = new HashSet<>();

	public Product() {}

	public Product(Long id, String name, String description, Double price,
			Integer stockQuantity, String imgUri) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.imgUri = imgUri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Set<Sale> getSales() {
		Set<Sale> sales = new HashSet<>();
		for (SaleItem saleItem : items) {
			sales.add(saleItem.getSale());
		}
		return sales;
	}

	public String getImgUri() {
		return imgUri;
	}
	
	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
