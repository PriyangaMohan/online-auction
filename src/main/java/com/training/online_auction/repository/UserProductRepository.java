package com.training.online_auction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.online_auction.entity.UsersProduct;

public interface UserProductRepository extends JpaRepository<UsersProduct, Long>{
	Optional<UsersProduct> findById(Long id);

	List<UsersProduct> findByProductId(Long id);
}
