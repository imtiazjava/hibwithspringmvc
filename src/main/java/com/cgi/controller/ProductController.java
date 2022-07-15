package com.cgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgi.dao.ProductDAO;
import com.cgi.model.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;

	public ProductController() {
		System.out.println("ProductController object is created..");
	}

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}


	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product) {
		this.productDAO.addProduct(product);
		return "display";

	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		List<Product> list = this.productDAO.getAllProducts();
		model.addAttribute("list", list);
		return "display";// view name
	}
	
	@RequestMapping(value="/product/{id}")
	public String deletProductById(@PathVariable("id") int id) {
		this.productDAO.deleteById(id);
		return "index";
	}

}
