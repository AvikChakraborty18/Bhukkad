package com.tables;

import java.io.Serializable;
import javax.persistence.*;



@Entity

public class Clogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String password;

	
	@ManyToOne
	@JoinColumn(name="EMAIL")
	private Cregister customerreg;

	public Clogin() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cregister getCustomerreg() {
		return this.customerreg;
	}

	public void setCustomerreg(Cregister customerreg) {
		this.customerreg = customerreg;
	}


}