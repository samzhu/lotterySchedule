package com.lottery.scheduled.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the v2_lotto_new_year database table.
 * 
 */
@Entity
@Table(name="v2_lotto_new_year")
@NamedQuery(name="V2LottoNewYear.findAll", query="SELECT v FROM V2LottoNewYear v")
public class V2LottoNewYear implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Integer group;

	private String note;

	private Integer number01;

	private Integer number02;

	private Integer number03;

	private Integer number04;

	private Integer number05;

	private Integer number06;

	private String serial;

	@Column(name="win_count")
	private Integer winCount;

	@Column(name="win_money")
	private Integer winMoney;

	public V2LottoNewYear() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getGroup() {
		return this.group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getNumber01() {
		return this.number01;
	}

	public void setNumber01(Integer number01) {
		this.number01 = number01;
	}

	public Integer getNumber02() {
		return this.number02;
	}

	public void setNumber02(Integer number02) {
		this.number02 = number02;
	}

	public Integer getNumber03() {
		return this.number03;
	}

	public void setNumber03(Integer number03) {
		this.number03 = number03;
	}

	public Integer getNumber04() {
		return this.number04;
	}

	public void setNumber04(Integer number04) {
		this.number04 = number04;
	}

	public Integer getNumber05() {
		return this.number05;
	}

	public void setNumber05(Integer number05) {
		this.number05 = number05;
	}

	public Integer getNumber06() {
		return this.number06;
	}

	public void setNumber06(Integer number06) {
		this.number06 = number06;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Integer getWinCount() {
		return this.winCount;
	}

	public void setWinCount(Integer winCount) {
		this.winCount = winCount;
	}

	public Integer getWinMoney() {
		return this.winMoney;
	}

	public void setWinMoney(Integer winMoney) {
		this.winMoney = winMoney;
	}

}