package com.tables;

import java.io.Serializable;
import javax.persistence.*;



@Entity

public class Rlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String password;

	//bi-directional many-to-one association to Rregister
	@ManyToOne
	@JoinColumn(name="RSID")
	private Rregister rregister;

	public Rlogin() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rregister getRregister() {
		return this.rregister;
	}

	public void setRregister(Rregister rregister) {
		this.rregister = rregister;
	}

}