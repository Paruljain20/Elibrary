package com.app.elib.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookWishList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int userId;
	private long bookId;
	private Date date;
	
	public BookWishList(int id, int userId, long bookId, Date date) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.date = date;
	}
	public BookWishList(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
