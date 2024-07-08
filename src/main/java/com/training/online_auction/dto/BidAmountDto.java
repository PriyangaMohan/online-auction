package com.training.online_auction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidAmountDto {
	
	
	private String bidAmount;
	
	private Long userId;
	
	private Long productId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(String bidAmount) {
		this.bidAmount = bidAmount;
	}

}
