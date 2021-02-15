package com.tnicacio.vendor.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tnicacio.vendor.entities.enums.SaleStatus;

@Entity
@Table(name = "Sale")
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	private Boolean creditSale;
	private Integer status;

	@OneToMany(mappedBy = "id.sale")
	private Set<SaleItem> items = new HashSet<>();

	@OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
	private Payment payment;

	public Sale() {
	}

	public Sale(Long id, Instant date, Boolean creditSale, SaleStatus status) {
		this.id = id;
		this.date = date;
		this.creditSale = creditSale;
		setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Boolean getCreditSale() {
		return creditSale;
	}

	public void setCreditSale(Boolean creditSale) {
		this.creditSale = creditSale;
	}

	public SaleStatus getStatus() {
		return SaleStatus.valueOf(status);
	}

	public void setStatus(SaleStatus status) {
		if (status != null) {
			this.status = status.getCode();
		}
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<SaleItem> getItems() {
		return items;
	}

	public Double getTotal() {
		Double sum = items.stream().map(i -> i.getSubTotal()).reduce(0.0, (a, b) -> a + b);
		return sum;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
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
		Sale other = (Sale) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
