package com.lottery.scheduled.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.scheduled.model.dao.*;
import com.lottery.scheduled.model.entity.*;

@Service
@Transactional
public class LottoDafuService {

	@Autowired
	private V2LottoDafuRepository V2LottoDafuRepository;
	@Autowired
	private V2LottoSettingRepository V2LottoSettingRepository;


	public V2LottoDafu findByID(String serial){
		return V2LottoDafuRepository.findOne(serial);
	}

	public V2LottoDafu saveLottoDafu(V2LottoDafu lottoDafu){
		return V2LottoDafuRepository.save(lottoDafu);
	}
	
	public V2LottoDafu calLostCount(V2LottoDafu currentLottoDafu){
		long lostCount = 0;
		if(currentLottoDafu.getWin01Count() == -1){
			
		}else if(currentLottoDafu.getWin01Count() > 0){
			lostCount = 0;
			V2LottoSetting lottoSetting = V2LottoSettingRepository.findByName("DafuLostCount");
			lottoSetting.setSetting(String.valueOf(lostCount));
			V2LottoSettingRepository.save(lottoSetting);
			V2LottoDafuRepository.save(currentLottoDafu);
		}else{
			V2LottoDafu lottoDafuRecordWin = V2LottoDafuRepository.findFirstByWin01CountGreaterThanOrderBySerialDesc(0);
			if(lottoDafuRecordWin == null){
				lostCount = V2LottoDafuRepository.count();
			}else{
				lostCount = V2LottoDafuRepository.findBySerialBetween(lottoDafuRecordWin.getSerial(), currentLottoDafu.getSerial()).size() -1;
			}
			V2LottoSetting lottoSetting = V2LottoSettingRepository.findByName("DafuLostCount");
			lottoSetting.setSetting(String.valueOf(lostCount));
			V2LottoSettingRepository.save(lottoSetting);
			V2LottoDafuRepository.save(currentLottoDafu);
		}
		return currentLottoDafu;
	}

}
