package com.tsswebapps.productms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import com.tsswebapps.productms.dto.ProductDto;

@SpringBootTest
public class SaveProductServiceTest {
	
	@Autowired
	private SaveProductService service;
	
	private boolean simulaValidation(ProductDto dto) {		
		boolean emptyName = ObjectUtils.isEmpty(dto.getName());
		boolean emptyDescription = ObjectUtils.isEmpty(dto.getDescription());
		boolean emptyPrice = ObjectUtils.isEmpty(dto.getPrice());		
		return emptyName || emptyDescription || emptyPrice;
	}

	@Test
	void DeveriaSalvarProdutoComTodosOsCamposInformados() {
		ProductDto productRequest = new ProductDto(null, "Nome Produto", "Descricao do produto", new BigDecimal(1));
		ProductDto productSaved = service.execute(simulaValidation(productRequest), productRequest.toProduct());
		assertNotNull(productSaved);
	}
	
	@Test
	void DeveriaDarBadRequestAoSalvarUmProdutoInvalido() {
		try {
			ProductDto productRequest = new ProductDto(null, "", "Descricao do produto", new BigDecimal(1));
			service.execute(simulaValidation(productRequest), productRequest.toProduct());
			assertTrue(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
