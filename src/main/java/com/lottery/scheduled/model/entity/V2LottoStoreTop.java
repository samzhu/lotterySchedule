package com.lottery.scheduled.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the v2_lotto_store_top database table.
 * 
 */
@Entity
@Table(name="v2_lotto_store_top")
@NamedQuery(name="V2LottoStoreTop.findAll", query="SELECT v FROM V2LottoStoreTop v")
public class V2LottoStoreTop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String area;

	private String city;

	private String serial;

	@Column(name="store_address")
	private String storeAddress;

	@Column(name="store_name")
	private String storeName;

	private String type;

	public V2LottoStoreTop() {
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

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}