package com.nagarro.springmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.springmvc.dao.ProductDao;
import com.nagarro.springmvc.model.Login;
import com.nagarro.springmvc.model.Product;
import com.nagarro.springmvc.model.User;
import com.nagarro.springmvc.readcsv.ReadCsv;
import com.nagarro.springmvc.service.UserService;


/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The user service. */
	@Autowired
	UserService userService;

	/**
	 * Show login.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		loadData();

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());

		return mav;
	}

	/**
	 * Load data.
	 */
	private void loadData() {

		ReadCsv csv = new ReadCsv();
		File[] CsvReader = csv.readCsvFromFolder();

		ArrayList<Product> records = new ArrayList<>();

		for (int i = 0; i < CsvReader.length; i++) {

			try {

				Scanner s;
				s = new Scanner(new File(String.valueOf(CsvReader[i])));

				s.useDelimiter("[|\n]");

				while (s.hasNext() && String.valueOf(s.hasNext()) != "COLOUR") {

					Product product = new Product();
					ProductDao productDao = new ProductDao();

					product.setId(s.next());

					product.setName(s.next());

					product.setColour(s.next());

					product.setGender_recomendation(s.next());

					product.setSize(s.next());

					product.setPrice(s.next());

					product.setRating(s.next());

					product.setAvailibility(s.next());

					records.add(product);

					productDao.saveProduct(product);
				}
			}

			catch (Exception e) {

				System.out.println("exception");
			}
		}

	}

	/**
	 * Login process.
	 *
	 * @param request the request
	 * @param response the response
	 * @param login the login
	 * @return the model and view
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;

		User user = userService.validateUser(login);

		if (null != user) {
			mav = new ModelAndView("welcome");
			mav.addObject("firstname", user.getFirstname());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}

		return mav;
	}

	/**
	 * Product form.
	 *
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(path = "/productform", method = RequestMethod.POST)
	public ModelAndView productForm(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String colour = request.getParameter("Colour");
		String size = request.getParameter("Size");
		String gender = request.getParameter("Gender");
		int sort = Integer.parseInt(request.getParameter("Preference"));

		ProductDao productDao = new ProductDao();

		List<Product> mydb = productDao.sessionGet();

		List<Product> list = searchRecord(colour, size, gender, mydb);

		System.out.println(list);

		switch (sort) {
		case 1:

			list.sort(Product.Comparators.PRICE);
			mav.addObject("product", list);
			mav.setViewName("product");
			list.clear();
			return mav;

		case 2:

			list.sort(Product.Comparators.SIZE);

			mav.addObject("product", list);
			mav.setViewName("product");
			list.clear();
			return mav;

		case 3:

			list.sort(Product.Comparators.BOTH);
			mav.addObject("product", list);
			mav.setViewName("product");
			list.clear();
			return mav;

		default:
			System.out.println("try another Tshirt");
			mav.setViewName("product");
			return mav;

		}


	}

	/**
	 * Search record.
	 *
	 * @param colour the colour
	 * @param size the size
	 * @param gender the gender
	 * @param mydb the mydb
	 * @return the list
	 */
	private static List<Product> searchRecord(String colour, String size, String gender, List<Product> mydb) {

		List<Product> list = mydb.stream().filter(obj -> obj.getColour().equals(colour) && obj.getSize().equals(size)
				&& obj.getGender_recomendation().equals(gender)).collect(Collectors.toList());
		return list;
	}

}
