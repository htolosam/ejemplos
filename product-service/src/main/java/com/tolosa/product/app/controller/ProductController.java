package com.tolosa.product.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolosa.product.app.models.entity.Product;
import com.tolosa.product.app.models.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> list() {
		return ResponseEntity.ok(productService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> list(@PathVariable String id) {
		return ResponseEntity.ok(productService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable String id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
