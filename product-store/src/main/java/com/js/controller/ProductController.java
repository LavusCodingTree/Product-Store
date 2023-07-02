package com.js.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.js.dao.ProductCRUD;
import com.js.dto.Product;

@Controller
public class ProductController {
	@Autowired
	ProductCRUD productCRUD;

	@RequestMapping("/load")
	public ModelAndView loadProduct() {
		ModelAndView mv = new ModelAndView("loadProduct.jsp");
		mv.addObject("product", new Product());
		return mv;
	}

	@RequestMapping("/save")
	public ModelAndView saveProduct(@ModelAttribute Product p) {
		ModelAndView mv = new ModelAndView("welcome.jsp");
		boolean result = productCRUD.insertProduct(p);
		if (result) {
			mv.addObject("msg", "Inserted Sucessfully");
		} else {
			mv.addObject("msg", "Failed To Insert");
		}
		return mv;
	}

	@RequestMapping("/display")
	public ModelAndView getallProducts() {

		List<Product> products = productCRUD.getAllProduct();

		if (products.size() > 0) {
			ModelAndView mv = new ModelAndView("display.jsp");
			mv.addObject("data", products);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("welcome.js");
			mv.addObject("msg", "No Products Avaliable");
			return mv;
		}
	}

	@RequestMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam int id) {
		boolean res = productCRUD.deleteProductById(1);

		if (res) {
			ModelAndView mv = new ModelAndView("display");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("welcome.jsp");
			mv.addObject("msg", "No Product is Avaliable To Delete");
			return mv;
		}

	}

	@RequestMapping("/edit")
	public ModelAndView updateProduct(@RequestParam int id) {
		Product p = productCRUD.getProductById(id);

		if (p != null) {
			ModelAndView mv = new ModelAndView("update.jsp");
			mv.addObject("pro", p);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("welcome.jsp");
			mv.addObject("msg", "No Product is Avaliable To Delete");
			return mv;
		}

	}
	
	@RequestMapping("/update")
	public ModelAndView updateProduct2(@ModelAttribute Product p) {
		boolean res = productCRUD.updateProductById(p.getId(), p);

		if (res) {
			ModelAndView mv = new ModelAndView("display");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("welcome.jsp");
			mv.addObject("msg", "No Product is Avaliable To Delete");
			return mv;
		}

	}
	
}
