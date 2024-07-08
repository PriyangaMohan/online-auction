package com.training.online_auction.controller;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.online_auction.dto.BidAmountDto;
import com.training.online_auction.dto.UserDto;
import com.training.online_auction.dto.UsersProductDto;
import com.training.online_auction.entity.Product;
import com.training.online_auction.entity.User;
import com.training.online_auction.entity.UsersProduct;
import com.training.online_auction.service.ProductService;
import com.training.online_auction.service.UserProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserProductService userProductService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		// The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	@GetMapping("/products")
	public String products(Model model) {
		// List<ProductDto> products = productService.findAllProducts();
		List<Product> products = productService.findAllProducts1();
		 
	      
		model.addAttribute("products", products);
		return "products";
	}

	@PostMapping("/products/addProducts")
	public String addProduct(@ModelAttribute("prod") Product prod, Model model) {
		// List<ProductDto> products = productService.findAllProducts();
		List<Product> products = productService.saveProduct(prod);
		model.addAttribute("products", products);
		return "products";
	}

	@GetMapping("/products/getProduct")
	public String getProduct(Model model) {
		// List<ProductDto> products = productService.findAllProducts();
		model.addAttribute("Command", new Product());
		return "addproduct";
	}

	@GetMapping("/products/bid/{id}")
	public String bid(@PathVariable("id") Long prodId, Model model) {
		Optional<Product> optional = productService.findByIdProducts(prodId);
		List<UsersProduct> productsList = userProductService.findByProductId(prodId);
		double maxBidValue = productsList.stream().max(Comparator.comparing(UsersProduct::getBidAmount)).get()
				.getBidAmount();

		List<Product> products = optional.stream().collect(Collectors.toList());
		
	        UsersProductDto usersProductDto = new UsersProductDto();
	       usersProductDto.setName(products.get(0).getName());
	       usersProductDto.setBidAmount(products.get(0).getBidAmount());
	       usersProductDto.setBitStartTime(products.get(0).getBitStartTime());
	       usersProductDto.setBitEndTime(products.get(0).getBitEndTime());
	       usersProductDto.setId(prodId);
	       usersProductDto.setMaxBidAmountDouble(maxBidValue);
	        
	        
		model.addAttribute("product", usersProductDto);
		model.addAttribute("bidAmountDto", new BidAmountDto());
		return "bidproduct";
	}

	/*
	 * @PostMapping("/products/bid/save/{id}") public String
	 * registration(@Valid @ModelAttribute("bidAmountDto") BidAmountDto
	 * bidamountDto,
	 * 
	 * @PathVariable("id") Long prodId, BindingResult result, Model model) {
	 * Optional<Product> productOptional = productService.findByIdProducts(prodId);
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * String userName = auth.getName();
	 * 
	 * User user = userService.findUserByEmail(userName); double bidamount =
	 * Double.parseDouble(bidamountDto.getBidAmount()); if (productOptional != null
	 * && bidamount > productOptional.get().getBidAmount()) {
	 * bidamountDto.setUserId((Long) user.getId());
	 * bidamountDto.setProductId(prodId);
	 * 
	 * userProductService.saveBid(bidamountDto); }
	 * 
	 * return "redirect:/product?success"; }
	 */

}
