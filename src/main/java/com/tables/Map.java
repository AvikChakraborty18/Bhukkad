package com.tables;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="MAPS")

public class Map implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String latitude;

	private String longitude;

	//bi-directional many-to-one association to Rregister
	@ManyToOne
	@JoinColumn(name="RSID")
	private Rregister rregister;

	public Map() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Rregister getRregister() {
		return this.rregister;
	}

	public void setRregister(Rregister rregister) {
		this.rregister = rregister;
	}

}