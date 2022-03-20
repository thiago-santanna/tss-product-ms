package com.tsswebapps.productms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.exception.BadRequestException;
import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.repository.ProductRepository;

@Service
public class SaveProductService {
	
	@Autowired
	private ProductRepository repository;	
	
	public ProductDto execute(boolean hasErrors, Product product) {
		if (hasErrors) {
			throw new BadRequestException("Dados inválidos");
		}
		
		Product productSaved = repository.save(product);				
		return productSaved.toDto();		
	}
}
