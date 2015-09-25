package com.lottery.scheduled.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the v2_lotto_analysis database table.
 * 
 */
@Entity
@Table(name="v2_lotto_analysis")
@NamedQuery(name="V2LottoAnalysi.findAll", query="SELECT v FROM V2LottoAnalysi v")
public class V2LottoAnalysi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer area;

	private Integer count;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Integer number;

	private String type;

	private String unit;

	public V2LottoAnalysi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArea() {
		return this.area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}