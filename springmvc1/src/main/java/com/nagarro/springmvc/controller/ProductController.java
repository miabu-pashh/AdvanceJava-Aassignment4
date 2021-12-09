package com.nagarro.springmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.nagarro.springmvc.dao.ProductDao;
import com.nagarro.springmvc.model.Product;
import com.nagarro.springmvc.readcsv.ReadCsv;


/**
 * The Class ProductController.
 */
public class ProductController {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
}
