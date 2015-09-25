package com.lottery.scheduled.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.scheduled.model.dao.*;
import com.lottery.scheduled.model.entity.*;

/**
 * 威力彩
 * @author samzhu
 *
 */

@Service
@Transactional
public class LottoPowerService {

	@Autowired
	private V2LottoPowerRepository V2LottoPowerRepository;
	
	@Autowired
	private V2LottoSettingRepository V2LottoSettingRepository;

	public V2LottoPower findLottoPowerById(String serial){
		V2LottoPower bean = V2LottoPowerRepository.findOne(serial);
		return bean;
	}

	public V2LottoPower saveLottoPower(V2LottoPower lottoPower){
		return V2LottoPowerRepository.save(lottoPower);
	}
	
	
	public V2LottoPower calLostCount(V2LottoPower currentLottoPower){
		long lostCount = 0;
		if(currentLottoPower.getWin01Count() == -1){
			//還沒有爬文不知道有沒有人中獎,所以不設定
		}else if(currentLottoPower.getWin01Count() > 0){
			//這期有人中獎
			lostCount = 0;
			V2LottoSetting lottoSetting = V2LottoSettingRepository.findByName("PowerLostCount");
			lottoSetting.setSetting(String.valueOf(lostCount));
			V2LottoSettingRepository.save(lottoSetting);
			V2LottoPowerRepository.save(currentLottoPower);
		}else{
			//這邊就是沒有人中獎，先找出前一筆中獎紀錄
			V2LottoPower lottoPowerRecordWin = V2LottoPowerRepository.findFirstByWin01CountGreaterThanOrderBySerialDesc(0);
			System.out.println("前一筆中獎號 lottoPowerRecordWin=" + lottoPowerRecordWin);
			lostCount = V2LottoPowerRepository.findBySerialBetween(lottoPowerRecordWin.getSerial(), currentLottoPower.getSerial()).size() - 1 ;
			System.out.println("槓幾期 lostCount=" + lostCount);
			V2LottoSetting lottoSetting = V2LottoSettingRepository.findByName("PowerLostCount");
			System.out.println("設定值 lottoSetting=" + lottoSetting);
			lottoSetting.setSetting(String.valueOf(lostCount));
			V2LottoSettingRepository.save(lottoSetting);
			V2LottoPowerRepository.save(currentLottoPower);
		}
		return currentLottoPower;
	}
}