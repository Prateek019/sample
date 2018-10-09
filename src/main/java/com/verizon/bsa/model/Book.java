package com.verizon.bsa.model;

public class Book{
	
	private int bcode;
	private String title;
	private double price;
	private String category;
	private String type;
	
	public Book(int i, String s, int j, String s2, String string3) {
		this.bcode=i;
		this.title=s;
		this.price=i;
		this.category=s2;
		this.type=string3;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}