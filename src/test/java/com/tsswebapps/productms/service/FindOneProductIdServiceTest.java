package com.tsswebapps.productms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.model.Product;

@SpringBootTest
class FindOneProductIdServiceTest {
	
	@Autowired
	private FindOneProductIdService findOneProductIdService;
	
	@Autowired
	private SaveProductService productService;
	
	private boolean simulaValidation(ProductDto dto) {		
		boolean emptyName = ObjectUtils.isEmpty(dto.getName());
		boolean emptyDescription = ObjectUtils.isEmpty(dto.getDescription());
		boolean emptyPrice = ObjectUtils.isEmpty(dto.getPrice());		
		return emptyName || emptyDescription || emptyPrice;
	}

	@Test
	void deveriaEncontrarUmProdutoComIdExistente() {
		ProductDto productRequest = new ProductDto(null, "Nome Produto", "Descricao do produto", new BigDecimal(1));
		ProductDto productSaved = productService.execute(simulaValidation(productRequest), productRequest.toProduct());
		
		Product product = findOneProductIdService.execute(UUID.fromString(productSaved.getId()));
		assertNotNull(product);
	}
	
	@Test
	void deveriaNaoEncontrarUmProdutoComIdErradoELevantarUmaExcecao() {
		
		try {
			ProductDto productRequest = new ProductDto(null, "Nome Produto", "Descricao do produto", new BigDecimal(1));
			productService.execute(simulaValidation(productRequest), productRequest.toProduct());
			
			findOneProductIdService.execute(UUID.fromString("ID-ERRADO"));
			assertTrue(false);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
