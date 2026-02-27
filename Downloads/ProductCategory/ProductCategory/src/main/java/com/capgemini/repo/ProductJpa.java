package com.capgemini.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.dto.Product;

public interface ProductJpa extends JpaRepository<Product, Integer> {
}
