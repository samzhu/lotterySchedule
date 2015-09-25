package com.lottery.scheduled.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.scheduled.model.dao.*;
import com.lottery.scheduled.model.entity.*;

/**
 * 今彩539
 * @author samzhu
 *
 */

@Service
@Transactional
public class LottoTodayService {

	@Autowired
	private V2LottoTodayRepository V2LottoTodayRepository;


	public V2LottoToday findLottoTodayById(String serial){
		V2LottoToday bean = V2LottoTodayRepository.findOne(serial);
		return bean;
	}

	public V2LottoToday saveLottoToday(V2LottoToday lottoToday){
		return V2LottoTodayRepository.saveAndFlush(lottoToday);
	}





}
