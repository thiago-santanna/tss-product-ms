package com.tsswebapps.productms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tsswebapps.productms.dto.ProductDto;

@SpringBootTest
public class SaveProductServiceTest {
	
	@Autowired
	private SaveProductService service;

	@Test
	void DeveriaSalvarProdutoComTodosOsCamposInformados() {
		ProductDto productRequest = new ProductDto(null, "Nome Produto", "Descricao do produto", new BigDecimal(1));
		ProductDto productSaved = service.execute(productRequest.toProduct());
		assertNotNull(productSaved);
	}
}
