package com.tsswebapps.productms.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.tsswebapps.productms.model.Product;
import com.tsswebapps.productms.repository.custom.AsimioJpaRepository;
import com.tsswebapps.productms.repository.custom.ProductSearchCriteria;
import com.tsswebapps.productms.repository.custom.QueryCallback;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, AsimioJpaRepository {

	default List<Product> findProductsQueryParams(ProductSearchCriteria criteria) {
		return findAll(new QueryCallback<List<Product>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Product> doWithEntityManager(EntityManager entityManager) {
				Map<String, Object> queryParams = this.buildQueryParameters();

				StringBuilder builder = new StringBuilder();
				// Query Native
				builder.append("SELECT * FROM PRODUCT ");
				builder.append("WHERE 1 = 1 ");
				builder.append((queryParams.get("minPrice") != null) ? "  AND price >= :minPrice" : "");
				builder.append((queryParams.get("maxPrice") != null) ? "  AND price <= :maxPrice" : "");
				builder.append((queryParams.get("queryNameDescription") != null)
						? " AND ( (name like :name) or (description  like :description) )" : "");

				// Parameters
				String nativeQuery = builder.toString();
				Query query = entityManager.createNativeQuery(nativeQuery, Product.class);

				if (queryParams.get("minPrice") != null) {
					query.setParameter("minPrice", queryParams.get("minPrice"));
				}
				if (queryParams.get("maxPrice") != null) {
					query.setParameter("maxPrice", queryParams.get("maxPrice"));
				}
				if (queryParams.get("queryNameDescription") != null) {
					query.setParameter("name", "%" + queryParams.get("queryNameDescription") + "%");
					query.setParameter("description", "%" + queryParams.get("queryNameDescription") + "%");
				}
				return query.getResultList();
			}

			private Map<String, Object> buildQueryParameters() {
				Map<String, Object> result = new HashMap<>();

				if (!ObjectUtils.isEmpty(criteria.getMinPrice())) {
					result.put("minPrice", criteria.getMinPrice());
				}
				if (!ObjectUtils.isEmpty(criteria.getMaxPrice())) {
					result.put("maxPrice", criteria.getMaxPrice());
				}
				if (!ObjectUtils.isEmpty(criteria.getQ())) {
					result.put("queryNameDescription", criteria.getQ());
				}
				return result;
			}
		});
	}
}
