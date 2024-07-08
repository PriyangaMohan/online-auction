package com.training.online_auction.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.online_auction.dto.BidAmountDto;
import com.training.online_auction.entity.Product;
import com.training.online_auction.entity.User;
import com.training.online_auction.service.ProductService;
import com.training.online_auction.service.UserProductService;
import com.training.online_auction.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UsersProductController {

	@Autowired
	private UserProductService userProductService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;
	
	public UsersProductController(UserProductService userProductService) {
		this.userProductService = userProductService;
	}
	@PostMapping("/products/bid/save/{id}")
	public String registration(@Valid @ModelAttribute("bidAmountDto") BidAmountDto bidamountDto,
			@PathVariable("id") Long prodId, BindingResult result, Model model) {
		Optional<Product> productOptional = productService.findByIdProducts(prodId);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();

		User user = userService.findUserByEmail(userName);
		double bidamount = Double.parseDouble(bidamountDto.getBidAmount());
		if (productOptional != null && bidamount > productOptional.get().getBidAmount()) {
			bidamountDto.setUserId((Long) user.getId());
			bidamountDto.setProductId(prodId);

			userProductService.saveBid(bidamountDto);
		}

		return "/product";
	}

}
