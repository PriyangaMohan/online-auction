package com.training.online_auction.dto;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersProductDto {
	
	
	private Long id;
	private String name;
	private Double bidAmount;
	private Date bitEndTime;
	private Date bitStartTime;
	private Double maxBidAmountDouble;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Date getBitEndTime() {
		return bitEndTime;
	}
	public void setBitEndTime(Date bitEndTime) {
		this.bitEndTime = bitEndTime;
	}
	public Date getBitStartTime() {
		return bitStartTime;
	}
	public void setBitStartTime(Date date) {
		this.bitStartTime = date;
	}
	public Double getMaxBidAmountDouble() {
		return maxBidAmountDouble;
	}
	public void setMaxBidAmountDouble(Double maxBidAmountDouble) {
		this.maxBidAmountDouble = maxBidAmountDouble;
	}
	
	
	
	

}
