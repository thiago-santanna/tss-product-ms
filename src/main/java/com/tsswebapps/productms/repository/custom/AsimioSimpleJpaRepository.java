package com.tsswebapps.productms.repository.custom;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class AsimioSimpleJpaRepository<E, ID extends Serializable> extends SimpleJpaRepository<E, ID>
		implements AsimioJpaRepository {

	public AsimioSimpleJpaRepository(JpaEntityInformation<E, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;		
	}

	private final EntityManager entityManager;

	@Override
	public <T> List<T> findAll(QueryCallback<List<T>> callback) {
		return callback.doWithEntityManager(this.entityManager);
	}

}
