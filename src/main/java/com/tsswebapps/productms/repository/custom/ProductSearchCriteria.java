package com.tsswebapps.productms.repository.custom;

import java.math.BigDecimal;

public class ProductSearchCriteria {
	private String q;
	private BigDecimal minPrice;
	private BigDecimal maxPrice;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

}
