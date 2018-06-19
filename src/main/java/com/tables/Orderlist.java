package com.tables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDERLIST database table.
 * 
 */
@Entity
@NamedQuery(name="Orderlist.findAll", query="SELECT o FROM Orderlist o")
public class Orderlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String items;
	
	private long quantity;

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="OID")
	private Order order;

	public Orderlist() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItems() {
		return this.items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}