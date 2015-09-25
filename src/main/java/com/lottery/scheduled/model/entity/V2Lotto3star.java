package com.lottery.scheduled.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

import lombok.Data;


/**
 * The persistent class for the v2_lotto_3star database table.
 * 
 */
@Data
@Entity
@Table(name="v2_lotto_3star")
public class V2Lotto3star implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String serial;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Integer number01;
	private Integer number02;
	private Integer number03;
}