package com.lottery.scheduled.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.scheduled.model.dao.*;
import com.lottery.scheduled.model.entity.*;

@Service
@Transactional
public class LottoBigService {
	
	@Autowired
	private V2LottoBigRepository V2LottoBigRepository;
	@Autowired
	private V2LottoSettingRepository V2LottoSettingRepository;
	
	public V2LottoBig findByID(String serial){
		return V2LottoBigRepository.findOne(serial);
	}
	
	public V2LottoBig save(V2LottoBig lottoBig){
		return V2LottoBigRepository.saveAndFlush(lottoBig);
	}
	
	/**
	 * 計算槓幾期
	 * @param lottoPowerCurrent
	 * @return 
	 */
	public V2LottoBig calLostCount(V2LottoBig currentLottoBig){
		long lostCount = 0;
		if(currentLottoBig.getWin01Count() == -1){
			//不做事，因為不知道有沒有人中獎
		}else if(currentLottoBig.getWin01Count() > 0){
			//有人中獎先設成1，以免前端不顯示
			lostCount = 0;
			V2LottoSetting lottoSetting = V2LottoSettingRepository.findByName("BigLostCount");
			lottoSetting.setSetting(String.valueOf(lostCount));
			V2LottoSettingRepository.save(lottoSetting);
			V2LottoBigRepository.save(currentLottoBig);
		}else{
			//當期沒人中獎，找出上一期頭獎
			V2LottoBig lottoBigRecordWin = V2LottoBigRepository.findFirstByWin01CountGreaterThanOrderBySerialDesc(0);
			//計算兩期差多少期
			lostCount = V2LottoBigRepository.findBySerialBetween(lottoBigRecordWin.getSerial(), currentLottoBig.getSerial()).size() -1;
			//更新槓幾期
			V2LottoSetting lottoSetting = V2LottoSettingRepository.findByName("BigLostCount");
			lottoSetting.setSetting(String.valueOf(lostCount));
			V2LottoSettingRepository.save(lottoSetting);
			V2LottoBigRepository.save(currentLottoBig);
		}
		return currentLottoBig;
	}
}
