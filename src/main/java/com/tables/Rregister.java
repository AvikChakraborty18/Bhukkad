package com.tables;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;



@Entity

public class Rregister implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	private String rsid;

	private String area;

	private String email;

	private String password;
	
	private String searchname;
	
	private String averagecost;

	public String getAveragecost() {
		return averagecost;
	}

	public void setAveragecost(String averagecost) {
		this.averagecost = averagecost;
	}

	public String getSearchname() {
		return searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}

	private BigDecimal phone;

	private String rname;
	

	//bi-directional many-to-one association to Rlogin
	@OneToMany(mappedBy="rregister")
	private List<Rlogin> rlogins;

	//bi-directional many-to-one association to Map
	@OneToMany(mappedBy="rregister")
	private List<Map> maps;

	public Rregister() {
	}

	public String getRsid() {
		return this.rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public List<Rlogin> getRlogins() {
		return this.rlogins;
	}

	public void setRlogins(List<Rlogin> rlogins) {
		this.rlogins = rlogins;
	}

	public Rlogin addRlogin(Rlogin rlogin) {
		getRlogins().add(rlogin);
		rlogin.setRregister(this);

		return rlogin;
	}

	public Rlogin removeRlogin(Rlogin rlogin) {
		getRlogins().remove(rlogin);
		rlogin.setRregister(null);

		return rlogin;
	}

	public List<Map> getMaps() {
		return this.maps;
	}

	public void setMaps(List<Map> maps) {
		this.maps = maps;
	}

	public Map addMap(Map map) {
		getMaps().add(map);
		map.setRregister(this);

		return map;
	}

	public Map removeMap(Map map) {
		getMaps().remove(map);
		map.setRregister(null);

		return map;
	}

}