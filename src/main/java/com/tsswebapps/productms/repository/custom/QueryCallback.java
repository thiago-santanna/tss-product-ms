package com.tsswebapps.productms.repository.custom;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface QueryCallback<T> {
	T doWithEntityManager(EntityManager entityManager);
}
