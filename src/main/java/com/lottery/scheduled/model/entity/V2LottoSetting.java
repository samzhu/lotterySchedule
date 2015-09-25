package com.lottery.scheduled.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the v2_lotto_setting database table.
 * 
 */
@Data
@Entity
@Table(name="v2_lotto_setting")
@NamedQuery(name="V2LottoSetting.findAll", query="SELECT v FROM V2LottoSetting v")
public class V2LottoSetting implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String name;
	private String setting;
}