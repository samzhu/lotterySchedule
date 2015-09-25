package com.lottery.scheduled.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the powerlotto database table.
 * 
 */
@Entity
public class Powerlotto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer b10count;

	private Integer b15count;

	private Integer b1count;

	private Integer b5count;

	private String date;

	private Integer dcount;

	private String num1;

	private String num2;

	private String num3;

	private String num4;

	private String num5;

	private String num6;

	private String num7;

	private Integer numsum;

	private String period;

	private Integer scount;

	private Integer t10count;

	private Integer t15count;

	private Integer t5count;

	private String week;

	public Powerlotto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getB10count() {
		return this.b10count;
	}

	public void setB10count(Integer b10count) {
		this.b10count = b10count;
	}

	public Integer getB15count() {
		return this.b15count;
	}

	public void setB15count(Integer b15count) {
		this.b15count = b15count;
	}

	public Integer getB1count() {
		return this.b1count;
	}

	public void setB1count(Integer b1count) {
		this.b1count = b1count;
	}

	public Integer getB5count() {
		return this.b5count;
	}

	public void setB5count(Integer b5count) {
		this.b5count = b5count;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDcount() {
		return this.dcount;
	}

	public void setDcount(Integer dcount) {
		this.dcount = dcount;
	}

	public String getNum1() {
		return this.num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return this.num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getNum3() {
		return this.num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}

	public String getNum4() {
		return this.num4;
	}

	public void setNum4(String num4) {
		this.num4 = num4;
	}

	public String getNum5() {
		return this.num5;
	}

	public void setNum5(String num5) {
		this.num5 = num5;
	}

	public String getNum6() {
		return this.num6;
	}

	public void setNum6(String num6) {
		this.num6 = num6;
	}

	public String getNum7() {
		return this.num7;
	}

	public void setNum7(String num7) {
		this.num7 = num7;
	}

	public Integer getNumsum() {
		return this.numsum;
	}

	public void setNumsum(Integer numsum) {
		this.numsum = numsum;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getScount() {
		return this.scount;
	}

	public void setScount(Integer scount) {
		this.scount = scount;
	}

	public Integer getT10count() {
		return this.t10count;
	}

	public void setT10count(Integer t10count) {
		this.t10count = t10count;
	}

	public Integer getT15count() {
		return this.t15count;
	}

	public void setT15count(Integer t15count) {
		this.t15count = t15count;
	}

	public Integer getT5count() {
		return this.t5count;
	}

	public void setT5count(Integer t5count) {
		this.t5count = t5count;
	}

	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

}