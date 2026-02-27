package com.capgemini.CustomerProducrCategory.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.CustomerProducrCategory.dto.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

}
