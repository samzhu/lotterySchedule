package com.lottery.scheduled.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

import lombok.Data;


/**
 * The persistent class for the v2_lotto_dafu database table.
 * 
 */

@Data
@Entity
@Table(name="v2_lotto_dafu")
@NamedQuery(name="V2LottoDafu.findAll", query="SELECT v FROM V2LottoDafu v")
public class V2LottoDafu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String serial;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Integer number01;
	private Integer number02;
	private Integer number03;
	private Integer number04;
	private Integer number05;
	private Integer number06;
	private Integer number07;
	@Column(name="win01_count")
	private Integer win01Count;
}