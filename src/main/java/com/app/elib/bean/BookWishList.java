package com.app.elib.bean;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class BookWishList {
	public BookWishList(int userId, long bookId, int noOfItems, Date date) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.noOfItems = noOfItems;
		this.date = date;
	}
	private int userId;
	private long bookId;
	private int noOfItems;
	private Date date;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
