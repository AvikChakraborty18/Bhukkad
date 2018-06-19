package com.tables;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String oid;

	private String email;

	private String rsid;
	
	private String address;
	 
	private long phone;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	//bi-directional many-to-one association to Orderlist
	@OneToMany(mappedBy="order")
	private List<Orderlist> orderlists;

	public Order() {
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRsid() {
		return this.rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public List<Orderlist> getOrderlists() {
		return this.orderlists;
	}

	public void setOrderlists(List<Orderlist> orderlists) {
		this.orderlists = orderlists;
	}

	public Orderlist addOrderlist(Orderlist orderlist) {
		getOrderlists().add(orderlist);
		orderlist.setOrder(this);

		return orderlist;
	}

	public Orderlist removeOrderlist(Orderlist orderlist) {
		getOrderlists().remove(orderlist);
		orderlist.setOrder(null);

		return orderlist;
	}

}