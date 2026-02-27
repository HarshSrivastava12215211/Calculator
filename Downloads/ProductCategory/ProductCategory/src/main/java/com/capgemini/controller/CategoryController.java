package com.capgemini.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.Category;
import com.capgemini.repo.CategoryJpa;

@RequestMapping("/category")
@RestController
public class CategoryController {
	
//	@Autowired
//	private CategoryJpa cjpa ;
	
	private final CategoryJpa cjpa ; 
	
	public CategoryController(CategoryJpa cjpa) {
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
			cat.setName(c.getName()) ;
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
