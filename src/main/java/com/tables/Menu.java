package com.tables;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity

public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String menucat;

	
	private String menuitem;

	private long price;

	private String rsid;

	public Menu() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMenucat() {
		return this.menucat;
	}

	public void setMenucat(String menucat) {
		this.menucat = menucat;
	}

	public String getMenuitem() {
		return this.menuitem;
	}

	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}

	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getRsid() {
		return this.rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

}