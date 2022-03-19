package com.tsswebapps.productms.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tsswebapps.productms.model.Product;

@SpringBootTest
class ProductsRepositoryTest {

	@Autowired
	private ProductsRepository repository;

	@Test
	void DeveriaSalvarProdutoComTodosOsCamposInformados() {
		Product product = new Product("Nome Produto", "Descricao do produto", new BigDecimal(1));
		Product productSave = repository.save(product);
		System.out.println(productSave.getName());
		assertNotNull(productSave);
	}
}
