package com.task.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

	private String name;
	private Date productData;
	private Double amount;
	private String currency;

	public Product(String name, String data, String amount, String currency) {
		this.name = name;
		this.productData = dateParser(data);
		this.amount = Double.parseDouble(amount);
		this.currency = currency;
	}

	private Date dateParser(String date) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date dateObject = df.parse(date);
			if (!df.format(dateObject).equals(date)) {
				throw new ParseException(date, 0);
			} else {
				return dateObject;
			}
		} catch (ParseException ex) { // not yyyy-mm-dd date.
			System.out.println(": Bad");
			System.out.println(date + " cannot be parsed as a date. format: yyyy-mm-dd.");
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getProductData() {
		return productData;
	}

	public void setProductData(String productData) {
		this.productData = dateParser(productData);
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productData == null) ? 0 : productData.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productData == null) {
			if (other.productData != null)
				return false;
		} else if (!productData.equals(other.productData))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " " + amount + " " + currency;
	}

}
