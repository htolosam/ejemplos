package com.tolosa.product.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolosa.product.app.models.dao.IProductDao;
import com.tolosa.product.app.models.entity.Product;
import com.tolosa.product.app.models.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao productDao;
	
	@Override
	public List<Product> findAll() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	public String helloWord(String hello) {
		return "hola " + hello;
	}

	@Override
	public Product findById(String id) {
		return null;
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public void delete(String id) {
		productDao.deleteById(id);
		
	}

}
