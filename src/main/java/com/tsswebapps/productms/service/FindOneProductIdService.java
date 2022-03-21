package com.tsswebapps.productms.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.productms.exception.NotFoundException;
import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.repository.ProductRepository;

@Service
public class FindOneProductIdService {
	@Autowired
	private ProductRepository repository;

	public Product execute(UUID id) {
		
		Optional<Product> optionalProduct = repository.findById(id);
		
		if (optionalProduct.isEmpty()) {
			throw new NotFoundException("Produto não encontrado.");
		}
		
		return optionalProduct.get();
	}
}
