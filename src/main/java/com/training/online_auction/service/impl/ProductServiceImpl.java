package com.training.online_auction.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.online_auction.dto.ProductDto;
import com.training.online_auction.entity.Product;
import com.training.online_auction.repository.ProductRepository;
import com.training.online_auction.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	  @Autowired
	   private ProductRepository productRepository;
	   
	   @Override
	    public List<Product> findAllProducts1() {
	        List<Product> product = productRepository.findAll();
	        return product.stream()
	                
	                .collect(Collectors.toList());
	    }
	   
		/*
		 * @Override public List<ProductDto> findAllProducts() { List<Product> product =
		 * productRepository.findAll(); return product.stream() .map((pdt) ->
		 * mapToUserDto(pdt)) .collect(Collectors.toList()); }
		 */
		/*
		 * private ProductDto mapToUserDto(Product product) { ProductDto productDto =
		 * new ProductDto(); productDto.setName(product.getName());
		 * productDto.setBidAmount(product.getBidAmount());
		 * productDto.setBidEndTime(product.getBitEndTime());
		 * 
		 * return productDto; }
		 */

	@Override
	public List<ProductDto> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> saveProduct(Product prod) {
		productRepository.save(prod);
		List<Product> product=findAllProducts1();
		return product;
		}

	@Override
	public Optional<Product> findByIdProducts(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> product=productRepository.findById(id);
		return product;
	}

	


}
