package com.lottery.scheduled.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.lottery.scheduled.model.entity.*;
import com.lottery.scheduled.obj.UdnResult;
import com.lottery.scheduled.parse.*;
import com.lottery.scheduled.service.*;

/**
 * 儲存新的開獎結果
 * @author samzhu
 *
 */
@Component
public class JobSaveNewRs{
	private Logger logger = LoggerFactory.getLogger("system");

	@Autowired
	private UDNparse udnparse;
	@Autowired
	private LottoTodayService lottoTodayService;
	@Autowired
	private LottoPowerService lottoPowerService;
	@Autowired
	private LottoBigService lottoBigService;
	@Autowired
	private Lotto4starService lotto4starService;
	@Autowired
	private Lotto3starService lotto3starService;
	@Autowired
	private LottoDafuService lottoDafuService;
	@Autowired
	private BiglottoService biglottoService;
	@Autowired
	private PowerWinCount powerWinCount;
	@Autowired
	private TodayWinCount todayWinCount;
	@Autowired
	private BigWinCount bigWinCount;
	@Autowired
	private DafuWinCount dafuWinCount;


	/**
	 * 更新今彩539最新開獎爬蟲結果
	 * @param crawlerLottoToday
	 */
	@Async
	public void saveLottoToday(V2LottoToday crawlerLottoToday){
		logger.info("今彩539-爬蟲 " + crawlerLottoToday);
		V2LottoToday lottoToday = null;
		try {
			lottoToday = lottoTodayService.findLottoTodayById(crawlerLottoToday.getSerial());
			if(lottoToday == null){
				lottoToday = lottoTodayService.saveLottoToday(crawlerLottoToday);
			}
			if(lottoToday.getWin01Count() == -1){
				Integer winCount = todayWinCount.parser(lottoToday.getSerial());
				if(winCount != null){
					lottoToday.setWin01Count(winCount);
					lottoToday = lottoTodayService.saveLottoToday(lottoToday);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		logger.info("今彩539-更新 " + lottoToday);
	}

	/**
	 * 更新威力彩最新開獎爬蟲結果
	 * @param CrawlerLottoPower UDN爬蟲資料
	 */
	@Async
	public void saveLottoPower(V2LottoPower crawlerLottoPower){
		logger.info("威力彩-爬蟲 " + crawlerLottoPower);
		V2LottoPower lottoPower = null;
		try {
			lottoPower = lottoPowerService.findLottoPowerById(crawlerLottoPower.getSerial());
			if(lottoPower == null){//資料庫沒有該筆期別，先儲存到資料庫
				lottoPower = lottoPowerService.saveLottoPower(crawlerLottoPower);
			}
			if(lottoPower.getWin01Count() == -1){//該期別還沒有中獎注數資料
				//去台彩網頁爬蟲中獎注數
				Integer winCount = powerWinCount.parser(lottoPower.getSerial());
				if(winCount != null){
					//爬蟲成功才處理
					lottoPower.setWin01Count(winCount);
					//lottoPower = lottoPowerService.saveLottoPower(lottoPower);
					//計算槓幾期
					lottoPower = lottoPowerService.calLostCount(lottoPower);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		logger.info("威力彩-更新 " + lottoPower);
	}
	
	/**
	 * 更新大樂透最新開獎爬蟲結果
	 * @param crawlerLottoBig UDN爬蟲資料
	 */
	@Async
	public void saveLottoBig(V2LottoBig crawlerLottoBig){
		logger.info("大樂透-爬蟲 " + crawlerLottoBig);
		V2LottoBig lottoBig = null;
		try {
			lottoBig = lottoBigService.findByID(crawlerLottoBig.getSerial());
			if(lottoBig == null){
				lottoBig = lottoBigService.save(crawlerLottoBig);
			}
			if(lottoBig.getWin01Count() == -1){
				Integer winCount = bigWinCount.parser(lottoBig.getSerial());
				if(winCount != null){
					lottoBig.setWin01Count(winCount);
					lottoBig = lottoBigService.calLostCount(lottoBig);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		logger.info("大樂透-更新 " + lottoBig);
	}

	@Async
	public void saveLotto4star(V2Lotto4star crawlerLotto4Star){
		logger.info("4星彩-爬蟲 " + crawlerLotto4Star);
		V2Lotto4star lotto4star = null;
		try {
			lotto4star = lotto4starService.findByID(crawlerLotto4Star.getSerial());
			if(lotto4star == null){
				lotto4star = lotto4starService.save(crawlerLotto4Star);
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		logger.info("4星彩-更新 " + crawlerLotto4Star);
	}

	@Async
	public void saveLotto3star(V2Lotto3star crawlerLotto3Star){
		logger.info("3星彩-爬蟲 " + crawlerLotto3Star);
		V2Lotto3star lotto3star = null;
		try {
			lotto3star = lotto3starService.findByID(crawlerLotto3Star.getSerial());
			if(lotto3star == null){
				lotto3star = lotto3starService.save(crawlerLotto3Star);
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		logger.info("3星彩-更新 " + lotto3star);
	}

	@Async
	public void saveLottoDafu(V2LottoDafu crawlerLottoDafu){
		logger.info("大福-爬蟲 " + crawlerLottoDafu);
		V2LottoDafu lottoDafu = null;
		try {
			lottoDafu = lottoDafuService.findByID(crawlerLottoDafu.getSerial());
			if(lottoDafu == null){
				lottoDafu = lottoDafuService.saveLottoDafu(crawlerLottoDafu);
			}
			if(lottoDafu.getWin01Count() == null || lottoDafu.getWin01Count() == -1){
				Integer winCount = dafuWinCount.parser(lottoDafu.getSerial());
				if(winCount != null){
					lottoDafu.setWin01Count(winCount);
					lottoDafu = lottoDafuService.calLostCount(lottoDafu);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		logger.info("大福-更新 " + lottoDafu);
	}	
}
