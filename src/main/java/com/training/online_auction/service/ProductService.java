package com.training.online_auction.service;

import java.util.List;
import java.util.Optional;

import com.training.online_auction.dto.ProductDto;
import com.training.online_auction.entity.Product;

public interface ProductService {

	 List<ProductDto> findAllProducts();
	 List<Product> findAllProducts1() ;
	 
	 List<Product> saveProduct(Product Prod);
	Optional<Product> findByIdProducts(Long id);
}
