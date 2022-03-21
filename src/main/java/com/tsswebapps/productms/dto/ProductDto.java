package com.tsswebapps.productms.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;

import com.tsswebapps.productms.model.Product;

public class ProductDto {
    
	private String id;
	
	@NotEmpty
	@NotBlank
	@NotFound
	private String name;
	
	@NotEmpty
	@NotBlank
	@NotFound
	private String description;
	
	@NotNull
	@NotFound
	@Min(0)
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
		return new Product(null, this.name, this.description, this.price);
	}

	public Product copyToProduct(Product actualProduct) {
		actualProduct.setName(this.name);
		actualProduct.setDescription(this.description);
		actualProduct.setPrice(this.price);
		return actualProduct;
	}
	
}
