package com.lottery.scheduled.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.lottery.scheduled.service.LottoPowerService;

/**
 * 更新頭獎中獎注數
 * @author samzhu
 *
 */
@Component
public class JobUpdateWinCount {
	
	private LottoPowerService lottoPowerService;
	
	
	@Async
	public void updatePower(){
		
	}
	
	
}
