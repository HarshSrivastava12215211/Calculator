package com.capgemini.CustomerProducrCategory.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.CustomerProducrCategory.dto.Category;
public interface CategoryJpaRepository extends JpaRepository<Category , Integer>{

}
