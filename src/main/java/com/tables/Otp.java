package com.tables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OTP database table.
 * 
 */
@Entity
@NamedQuery(name="Otp.findAll", query="SELECT o FROM Otp o")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String email;

	public Otp() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}