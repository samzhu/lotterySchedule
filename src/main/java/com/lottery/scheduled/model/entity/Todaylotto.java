package com.lottery.scheduled.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the todaylotto database table.
 * 
 */
@Data
@Entity
public class Todaylotto implements Serializable {
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
	private Integer numsum;
	private String period;
	private Integer scount;
	private Integer t10count;
	private Integer t15count;
	private Integer t5count;
	private String week;
}