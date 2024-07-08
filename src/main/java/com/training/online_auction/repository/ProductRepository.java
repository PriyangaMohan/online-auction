package com.training.online_auction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.online_auction.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);;
    

}
