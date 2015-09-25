package com.lottery.scheduled.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lottery.scheduled.model.entity.*;

public interface V2LottoBigRepository extends JpaRepository<V2LottoBig, String>{
	/**
	 * 找出前一筆大於指定中獎期數
	 * @param win01Count
	 * @return
	 */
	public V2LottoBig findFirstByWin01CountGreaterThanOrderBySerialDesc(Integer win01Count);
	
	public List<V2LottoBig> findBySerialBetween(String serialStart, String serialEnd);
}
