package com.app.elib.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ebid;
	private String name;
	private String detail;
	private float price;
	private String author;
	private String category;
	private long isbn;
	private String ebook;
	public Book(long ebid, String name, String detail, float price, String author, String category, long isbn,
			String ebook) {
		super();
		this.ebid = ebid;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.author = author;
		this.category = category;
		this.isbn = isbn;
		this.ebook = ebook;
	}
	public String getEbook() {
		return ebook;
	}
	public void setEbook(String ebook) {
		this.ebook = ebook;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	public long getEbid() {
		return ebid;
	}
	public void setEbid(long ebid) {
		this.ebid = ebid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Book(){
	}
}
