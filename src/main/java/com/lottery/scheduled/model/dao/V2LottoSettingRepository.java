package com.lottery.scheduled.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lottery.scheduled.model.entity.*;

public interface V2LottoSettingRepository extends JpaRepository<V2LottoSetting, Integer>{
	
	public V2LottoSetting findByName(String name);

}
