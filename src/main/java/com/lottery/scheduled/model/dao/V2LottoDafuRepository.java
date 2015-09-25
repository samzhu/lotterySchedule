package com.lottery.scheduled.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lottery.scheduled.model.entity.*;

public interface V2LottoDafuRepository extends JpaRepository<V2LottoDafu, String>{
	/**
	 * 找出大於多少Win01Count的最新一筆(前一筆中獎)
	 * @param win01Count
	 * @return
	 */
	public V2LottoDafu findFirstByWin01CountGreaterThanOrderBySerialDesc(Integer win01Count);
	
	/**
	 * 計算兩期差幾期
	 * @param serialStart
	 * @param serialEnd
	 * @return
	 */
	public List<V2LottoDafu> findBySerialBetween(String serialStart, String serialEnd);

}
