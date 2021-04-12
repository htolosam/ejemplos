package com.tolosa.product.app.models.service;

import java.util.List;

import com.tolosa.product.app.models.entity.Product;
/**
 * 
 * Interfaz de contrato para el manejo del producto
 * @author ho tolosa
 *
 */
public interface IProductService {

	
	public List<Product> findAll();
	
	public Product findById(String id);
	
	public Product save(Product product);
	
	public void delete(String id);
	public String helloWord(String hello);
	
}
