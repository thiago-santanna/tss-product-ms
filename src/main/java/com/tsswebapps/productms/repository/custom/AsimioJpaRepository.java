package com.tsswebapps.productms.repository.custom;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AsimioJpaRepository {
	 <T> List<T> findAll(QueryCallback<List<T>> callback);
}
