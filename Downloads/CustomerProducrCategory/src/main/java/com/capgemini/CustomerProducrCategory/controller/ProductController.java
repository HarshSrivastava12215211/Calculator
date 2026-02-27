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

import com.capgemini.CustomerProducrCategory.dto.Product;
import com.capgemini.CustomerProducrCategory.repo.ProductJpaRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
//	@Autowired
//	private ProductJpa pjpa ; // Autowired
	
	private final ProductJpaRepository pjpa ; 
	
	public ProductController(ProductJpaRepository pjpa) { // constructor - injection
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
			pro.setProductName(p.getProductName()); 
			pro.setPrice(p.getPrice()) ; 
			pro.setCategory(p.getCategory()) ; 
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
			p.setCategory(null ) ; 
			pjpa.save(p) ; 
			pjpa.delete(p) ;
			return "Deleted" ; 
		}
		else {
			return "Data not found" ;
		}
	}
}

