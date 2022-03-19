package com.tsswebapps.productms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.exception.BadRequestException;
import com.tsswebapps.productms.service.SaveProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private SaveProductService saveProductService;
	
	@PostMapping
	public ResponseEntity<ProductDto> salvProduct(@RequestBody @Valid ProductDto productDto, BindingResult result) {
		if(result.hasErrors()) {
			throw new BadRequestException("Dados inválidos");
		}		
		
		ProductDto productSaved = saveProductService.execute(productDto.toProduct());		
		return new ResponseEntity<ProductDto>(productSaved, HttpStatus.CREATED);
	}

}
