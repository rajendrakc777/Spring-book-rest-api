package com.dto;

public class BookDTO {
	private int id;
	private String name;
	private int price;
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDTO(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BootDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	

}
