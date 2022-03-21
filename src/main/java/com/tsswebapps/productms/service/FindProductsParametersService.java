package com.tsswebapps.productms.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.tsswebapps.productms.dto.ProductDto;
import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.repository.ProductRepository;
import com.tsswebapps.productms.repository.custom.ProductSearchCriteria;

@Service
public class FindProductsParametersService {

	@Autowired
	private ProductRepository repository;

	public List<ProductDto> execute(String q, BigDecimal min_price, BigDecimal max_price) {

		if (ObjectUtils.isEmpty(q) && ObjectUtils.isEmpty(min_price) && ObjectUtils.isEmpty(max_price)) {
			return new ArrayList<>();
		}

		ProductSearchCriteria criteria = new ProductSearchCriteria();
		criteria.setQ(q);
		criteria.setMinPrice(min_price);
		criteria.setMaxPrice(max_price);
		List<Product> findProductsQueryParams = repository.findProductsQueryParams(criteria);
		return findProductsQueryParams.stream().map(Product::toDto).collect(Collectors.toList());
	}
}
