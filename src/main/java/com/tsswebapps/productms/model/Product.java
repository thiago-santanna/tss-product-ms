package com.tsswebapps.productms.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.NumberFormat;

import com.tsswebapps.productms.dto.ProductDto;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(nullable = false)
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(nullable = false)
	private String description;
	
	@NumberFormat(pattern = "#,##.00")
	@Column(nullable = false)
	private BigDecimal price;

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Product() {}
	
	public Product(UUID id, String name, String description, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public ProductDto toDto() {
		return new ProductDto(this.id.toString(), this.name, this.description, this.price);
	}
	
}
