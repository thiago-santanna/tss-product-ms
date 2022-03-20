package com.tsswebapps.productms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.repository.ProductRepository;

@Service
public class FindAllProducts {
	
	@Autowired
	private ProductRepository repository;

	
	public List<ProductDto> execute(){
		List<Product> allProducts = repository.findAll();
		
		return allProducts.stream()
				.map(Product::toDto).collect(Collectors.toList());
	}
}
