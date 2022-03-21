package com.tsswebapps.productms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.repository.ProductRepository;

@Service
public class SearchProductsService {
	@Autowired
	private ProductRepository repository;
	
	public List<ProductDto> execute(){
		
		
		return null;
	}
}
