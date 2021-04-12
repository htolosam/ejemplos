package com.tolosa.product.app.models.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tolosa.product.app.models.entity.Product;

@EnableScan
@Repository
public interface IProductDao extends CrudRepository<Product, String> {

}
