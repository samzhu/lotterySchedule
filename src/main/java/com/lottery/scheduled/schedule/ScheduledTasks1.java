package com.lottery.scheduled.schedule;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lottery.scheduled.job.JobSaveNewRs;
import com.lottery.scheduled.model.entity.V2LottoPower;
import com.lottery.scheduled.obj.UdnResult;
import com.lottery.scheduled.parse.UDNparse;

@Component
public class ScheduledTasks1 {
	private Logger logger = LoggerFactory.getLogger("system");
	
	private final AtomicInteger counter = new AtomicInteger();

	@Autowired
	private JobSaveNewRs job;
	
	@Autowired
	private UDNparse udnparse;

	@Scheduled(fixedRate = 1 * 60 * 1000, initialDelay = 1 * 1000)
	public void reportCurrentTime() {
		logger.info("排程開始");
		UdnResult udnResult = udnparse.getNewParse();
		
		if(udnResult.getLottoToday() != null)
			job.saveLottoToday(udnResult.getLottoToday());
		if(udnResult.getLottoPower() != null)
			job.saveLottoPower(udnResult.getLottoPower());
		if(udnResult.getLottoBig() != null)
			job.saveLottoBig(udnResult.getLottoBig());
		if(udnResult.getLotto4Star() != null)
			job.saveLotto4star(udnResult.getLotto4Star());
		if(udnResult.getLotto3Star() != null)
			job.saveLotto3star(udnResult.getLotto3Star());
		if(udnResult.getLottoDafu() != null)
			job.saveLottoDafu(udnResult.getLottoDafu());
		
		logger.info("排程結束");
	}
}
