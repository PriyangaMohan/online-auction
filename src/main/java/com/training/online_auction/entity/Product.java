package com.training.online_auction.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(name = "bit_amount", nullable = false)
	private double bidAmount;

	@Column(name = "bit_end_time", nullable = false)
	private Date bitEndTime;
	
	@Column(name = "bit_start_time", nullable = false)
	private Date bitStartTime;

	
	/*
	 * @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	 * 
	 * @JoinTable( name="users_product", joinColumns={@JoinColumn(name="USER_ID",
	 * referencedColumnName="ID")},
	 * inverseJoinColumns={@JoinColumn(name="PRODUCT_ID",
	 * referencedColumnName="ID")}) private List<User> users = new ArrayList<>();
	 */


	public Date getBitStartTime() {
		return bitStartTime;
	}


	public void setBitStartTime(Date bitStartTime) {
		this.bitStartTime = bitStartTime;
	}


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


	public double getBidAmount() {
		return bidAmount;
	}


	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}


	public Date getBitEndTime() {
		return bitEndTime;
	}


	public void setBitEndTime(Date bitEndTime) {
		this.bitEndTime = bitEndTime;
	}


	/*
	 * public List<User> getUsers() { return users; }
	 * 
	 * 
	 * public void setUsers(List<User> users) { this.users = users; }
	 */


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
	  
	 

}
