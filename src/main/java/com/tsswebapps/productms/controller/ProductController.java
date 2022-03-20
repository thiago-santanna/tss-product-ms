package com.tsswebapps.productms.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.service.FindOneProductId;
import com.tsswebapps.productms.service.SaveProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private SaveProductService saveProductService;
	
	@Autowired
	private FindOneProductId findOneProductId;
	

	@PostMapping
	public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductDto productDto,
			BindingResult validationFields) {
		
		ProductDto savedProduct = saveProductService.execute(validationFields.hasErrors(), 
				productDto.toProduct());
		
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable UUID id, @RequestBody @Valid ProductDto productDto,
			BindingResult validationFields) {
		
		Product actualProduct = findOneProductId.execute(id);		
		ProductDto updatedProduct = saveProductService.execute(validationFields.hasErrors(), 
				productDto.copyToProduct(actualProduct));
		
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> findOneProduct(@PathVariable UUID id){
		Product findedProduct = findOneProductId.execute(id);		
		return new ResponseEntity<>(findedProduct.toDto(), HttpStatus.OK);
	}
	
	public ResponseEntity<List<ProductDto>> allProducts(@PathVariable UUID id){	
		return null;
	}
	

}
