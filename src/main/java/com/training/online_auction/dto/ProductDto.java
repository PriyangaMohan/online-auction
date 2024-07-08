package com.training.online_auction.dto;


import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	
	 private Long id;
	   
	 @NotEmpty
	    private String name;
	 
	 @NotEmpty
	    private Double bidAmount;
	    
	    @NotEmpty
	    private Date bidEndTime;

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

		public Date getBidEndTime() {
			return bidEndTime;
		}

		public void setBidEndTime(Date bidEndTime) {
			this.bidEndTime = bidEndTime;
		}
	 

}
