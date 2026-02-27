package com.capgemini.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.Category;
import com.capgemini.dto.Product;
import com.capgemini.repo.ProductJpa;

@RestController
@RequestMapping("/product")
public class ProductController {
	
//	@Autowired
//	private ProductJpa pjpa ; // Autowired
	
	private final ProductJpa pjpa ; 
	
	public ProductController(ProductJpa pjpa) { // constructor - injection
		this.pjpa = pjpa ;
	}
	
	@PostMapping("/create")
	public String createProduct(@RequestBody Product p) {
		pjpa.save(p) ; 
		return "Inserted" ; 
	}
	
	@GetMapping("/get-product/{id}")
	public String getProduct(@PathVariable int id) {
		Optional<Product> option = pjpa.findById(id) ; 
		if(option.isPresent()) {
			return option.get().toString() ;
		}
		return "Data doesn't exist";
	}
	
	@PutMapping("/update-pro/{id}")
	public String updateProduct(@PathVariable int id ,@RequestBody Product p) {
		Optional<Product> option = pjpa.findById(id) ; 
		if(option.isPresent()) {
			Product pro = option.get() ; 
			pro.setName(p.getName()); 
			pro.setPrice(p.getPrice()) ; 
			pro.setC(p.getC()) ; 
			pjpa.save(pro) ; // save again 
			return "Updated" ; 
		}
		else {
			return "Data not available" ;
		}
	}
	
	@DeleteMapping("/delete-pro/{id}")
	public String deleteProduct(@PathVariable int id) {
		Optional<Product> option = pjpa.findById(id) ; 
		if(option.isPresent()) {
			Product p = option.get() ;
			p.setC(null ) ; 
			pjpa.save(p) ; 
			pjpa.delete(p) ;
			return "Deleted" ; 
		}
		else {
			return "Data not found" ;
		}
	}
}
