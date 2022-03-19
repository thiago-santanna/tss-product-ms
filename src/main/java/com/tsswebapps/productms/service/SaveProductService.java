package com.tsswebapps.productms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.repository.ProductRepository;

@Service
public class SaveProductService {
	
	@Autowired
	private ProductRepository repository;	
	
	public ProductDto execute(Product product) {
		Product productSaved = repository.save(product);				
		return productSaved.toDto();		
	}
}
