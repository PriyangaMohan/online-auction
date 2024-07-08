package com.training.online_auction.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.online_auction.dto.BidAmountDto;
import com.training.online_auction.entity.UsersProduct;
import com.training.online_auction.repository.UserProductRepository;
import com.training.online_auction.service.UserProductService;

@Service
public class UserProductServiceImpl implements UserProductService{

@Autowired
	private UserProductRepository userProductRepository;
	
	@Override
	public void saveBid(BidAmountDto bidAmountDto) {
		
		UsersProduct usersProduct=new UsersProduct();
		
		usersProduct.setUserId(bidAmountDto.getUserId());
		usersProduct.setProductId(bidAmountDto.getProductId());
		usersProduct.setBidAmount(Double.parseDouble(bidAmountDto.getBidAmount()));
		usersProduct.setBitTime(new Date());
		
		userProductRepository.save(usersProduct);
	}

	@Override
	public List<UsersProduct> findByProductId(Long id) {
		List<UsersProduct> userproduct = userProductRepository.findByProductId(id);
		
		
		return userproduct;
	}

}
