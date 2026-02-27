package com.capgemini.CustomerProducrCategory.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.CustomerProducrCategory.dto.Category;
import com.capgemini.CustomerProducrCategory.repo.CategoryJpaRepository;

@RequestMapping("/category")
@RestController
public class CategoryController {
	
//	@Autowired
//	private CategoryJpa cjpa ;
	
	private final CategoryJpaRepository cjpa ; 
	
	public CategoryController(CategoryJpaRepository cjpa) {
		this.cjpa = cjpa ;
	}
	
	@PostMapping("/create")
	public String createCategory(@RequestBody Category c) {
		cjpa.save(c) ;
		return "Inserted" ;
	}
	
	@GetMapping("/get-category/{id}")
	public String getCategory(@PathVariable int id) {
		Optional<Category> option = cjpa.findById(id) ; 
		if(option.isPresent()) {
			return option.get().toString() ;
		}
		return "Data doesn't exist";
	}
	
	@PutMapping("/update-cat/{id}")
	public String updateCategory(@PathVariable int id ,@RequestBody Category c) {
		Optional<Category> option = cjpa.findById(id) ; 
		if(option.isPresent()) {
			Category cat = option.get() ; 
			cat.setDescription(c.getDescription()) ;
			cat.setCategoryName(c.getCategoryName()) ;
			cjpa.save(cat) ; // save again 
			return "Updated" ; 
		}
		else {
			return "Data not available" ;
		}
	}
	
	@DeleteMapping("/delete-cat/{id}")
	public String deleteCategory(@PathVariable int id) {
		Optional<Category> option = cjpa.findById(id) ; 
		if(option.isPresent()) {
			Category c = option.get() ; 
			cjpa.delete(c) ;
			return "Deleted" ; 
		}
		else {
			return "Data not found" ;
		}
	}
}
