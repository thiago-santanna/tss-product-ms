package com.tsswebapps.productms.dto;

import java.math.BigDecimal;

import com.tsswebapps.productms.model.Product;

public class ProductDto {

	private String id;
	private String name;
	private String description;
	private BigDecimal price;

	public String getId() {
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

	public ProductDto(String id, String name, String description, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product toProduct() {
		return new Product(this.name, this.description, this.price);
	}

}
