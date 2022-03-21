package com.tsswebapps.productms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tsswebapps.productms.repository.custom.AsimioSimpleJpaRepository;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = AsimioSimpleJpaRepository.class)
@EnableTransactionManagement
public class ProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsApplication.class, args);
	}

}
