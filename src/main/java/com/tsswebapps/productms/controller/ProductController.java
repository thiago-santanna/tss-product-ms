package com.tsswebapps.productms.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.service.DeleteProductService;
import com.tsswebapps.productms.service.FindAllProductsService;
import com.tsswebapps.productms.service.FindOneProductIdService;
import com.tsswebapps.productms.service.FindProductsParametersService;
import com.tsswebapps.productms.service.SaveProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private SaveProductService saveProductService;
	
	@Autowired
	private FindOneProductIdService findOneProductIdService;
	
	@Autowired
	private FindAllProductsService findAllProductsService;
	
	@Autowired
	private FindProductsParametersService findProductsParametersService;
	
	@Autowired
	private DeleteProductService deleteProductService;
	

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
		
		Product actualProduct = findOneProductIdService.execute(id);		
		ProductDto updatedProduct = saveProductService.execute(validationFields.hasErrors(), 
				productDto.copyToProduct(actualProduct));
		
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> findOneProduct(@PathVariable UUID id){
		Product findedProduct = findOneProductIdService.execute(id);		
		return new ResponseEntity<>(findedProduct.toDto(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> allProducts(){	
		List<ProductDto> all = findAllProductsService.execute();
		
		return new ResponseEntity<>(all, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<ProductDto>> searchProducts(
			@RequestParam(required = false, name = "q") String q,
			@RequestParam(required = false, name = "min_price") BigDecimal min_price,
			@RequestParam(required = false, name = "max_price") BigDecimal max_price){
		
		List<ProductDto> products = findProductsParametersService.execute(q, min_price, max_price);
				
		return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> updateProduct(@PathVariable UUID id) {
		
		Product actualProduct = findOneProductIdService.execute(id);
		deleteProductService.execute(actualProduct);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
