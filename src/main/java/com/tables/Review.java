package com.tables;


import javax.persistence.*;



@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String feedname;
	private String feedcomment;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeedname() {
		return feedname;
	}
	public void setFeedname(String feedname) {
		this.feedname = feedname;
	}
	public String getFeedcomment() {
		return feedcomment;
	}
	public void setFeedcomment(String feedcomment) {
		this.feedcomment = feedcomment;
	}
}
	