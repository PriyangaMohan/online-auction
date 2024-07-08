package com.training.online_auction.service;

import java.util.List;

import com.training.online_auction.dto.BidAmountDto;
import com.training.online_auction.entity.UsersProduct;

public interface UserProductService {

	void saveBid(BidAmountDto bidAmountDto);

	List<UsersProduct> findByProductId(Long id);

}
