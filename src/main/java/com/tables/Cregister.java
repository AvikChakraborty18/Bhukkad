package com.tables;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;



@Entity

public class Cregister implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String fname;

	private String password;

	private BigDecimal phone;

	private String sname;

	@OneToMany(mappedBy="customerreg")
	private List<Clogin> customerlogins;

	public Cregister() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getPhone() {
		return this.phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Clogin> getCustomerlogins() {
		return this.customerlogins;
	}

	public void setCustomerlogins(List<Clogin> customerlogins) {
		this.customerlogins = customerlogins;
	}

	public Clogin addCustomerlogin(Clogin customerlogin) {
		getCustomerlogins().add(customerlogin);
		customerlogin.setCustomerreg(this);

		return customerlogin;
	}

	public Clogin removeCustomerlogin(Clogin customerlogin) {
		getCustomerlogins().remove(customerlogin);
		customerlogin.setCustomerreg(null);

		return customerlogin;
	}

}