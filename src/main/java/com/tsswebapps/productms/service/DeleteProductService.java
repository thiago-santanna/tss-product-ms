package com.tsswebapps.productms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.repository.ProductRepository;

@Service
public class DeleteProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public void execute(Product product) {
		repository.delete(product);
	}
}
