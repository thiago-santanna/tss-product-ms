package com.tsswebapps.productms.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.tsswebapps.productms.model.Product;

class ProductsRepositoryTest {

	private ProductsRepository repository;

	@Test
	void DeveriaSalvarProdutoComTodosOsCamposInformados() {
		Product product = new Product("Nome Produto", "Descricao do produto", new BigDecimal(1));
		Product productSave = repository.save(product);
		assertNotNull(productSave);
	}
}
