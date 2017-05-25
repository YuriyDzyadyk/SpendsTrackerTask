package com.task.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.json.simple.parser.ParseException;

public class ProductList {

	private JsonParser jsonParser = new JsonParser();
	private Map<Date, Set<Product>> map;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public ProductList() {
		map = new TreeMap<>();
	}

	public void add(String data) {
		// \\s(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$) split by space ignore space in quotes add
		// "^\"|\"$", "" replace quotes
		String regex = "\\s(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
		String[] productData = data.split(regex);
		Product product = new Product(productData[3].replaceAll("^\"|\"$", ""), productData[0], productData[1],
				productData[2].toUpperCase());

		Set<Product> set = map.get(product.getProductData());
		if (set == null) {
			set = new LinkedHashSet<Product>();
			map.put(product.getProductData(), set);
		}
		set.add(product);
		list();
	}

	public void list() {
		// [\\[\\],]","\n" replace [], by \n
		for (Entry<Date, Set<Product>> entry : map.entrySet()) {
			Date key = entry.getKey();
			Set<Product> value = entry.getValue();
			System.out.println(sdf.format(key));
			System.out.println(value.toString().replaceAll("[\\[\\],]", "\n"));
		}
	}

	public void delete(String productData) {
		map.remove(productData);
		list();

	}

	public void total(String base) throws IOException, ParseException {
		double ammount = 0;
		for (Entry<Date, Set<Product>> entry : map.entrySet()) {
			Set<Product> value = entry.getValue();
			for (Product product : value) {

				if (!base.equalsIgnoreCase(product.getCurrency())) {
					double convertedAmmount = jsonParser.parse(base.toUpperCase(), product.getCurrency());
					ammount = ammount + (product.getAmount() / convertedAmmount);
				} else {
					ammount += product.getAmount();
				}
			}
		}
		System.out.printf("%.2f", ammount);
	}
}
