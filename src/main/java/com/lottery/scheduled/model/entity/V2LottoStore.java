package com.lottery.scheduled.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the v2_lotto_store database table.
 * 
 */
@Entity
@Table(name="v2_lotto_store")
@NamedQuery(name="V2LottoStore.findAll", query="SELECT v FROM V2LottoStore v")
public class V2LottoStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String area;

	private String city;

	private double latitude;

	private double longitude;

	@Column(name="store_address")
	private String storeAddress;

	@Column(name="store_name")
	private String storeName;

	public V2LottoStore() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}