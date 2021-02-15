package com.tnicacio.vendor.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tnicacio.vendor.entities.pk.SaleProductPK;

@Entity
@Table(name = "Sale_items")
public class SaleItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SaleProductPK id = new SaleProductPK();

	private Integer quantity;
	
	@Column(columnDefinition = "DECIMAL(14,4)")
	private Double price;
	
	public SaleItem() {}

	public SaleItem(Sale sale, Product product, Integer quantity, Double price) {
		super();
		id.setSale(sale);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Sale getSale() {
		return id.getSale();
	}

	public void setSale(Sale sale) {
		id.setSale(sale);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SaleItem other = (SaleItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	


}
