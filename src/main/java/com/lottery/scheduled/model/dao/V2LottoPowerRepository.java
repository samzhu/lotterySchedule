package com.lottery.scheduled.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lottery.scheduled.model.entity.*;

public interface V2LottoPowerRepository extends JpaRepository<V2LottoPower, String>{
	
	//public V2LottoPower findFirstByOrderBySerialAsc();
	
	/**
	 * 找出大於多少Win01Count的最新一筆(前一筆中獎)
	 * @param win01Count
	 * @return
	 */
	public V2LottoPower findFirstByWin01CountGreaterThanOrderBySerialDesc(Integer win01Count);
	
	/**
	 * 計算兩期差幾期
	 * @param serialStart
	 * @param serialEnd
	 * @return
	 */
	public List<V2LottoPower> findBySerialBetween(String serialStart, String serialEnd);
}
