package com.lottery.scheduled.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.scheduled.model.dao.*;
import com.lottery.scheduled.model.entity.*;

@Service
@Transactional
public class Lotto4starService {

	@Autowired
	private V2Lotto4starRepository V2Lotto4starRepository;
	
	public V2Lotto4star findByID(String serial){
		return V2Lotto4starRepository.findOne(serial);
	}
	
	public V2Lotto4star save(V2Lotto4star lotto4star){
		return V2Lotto4starRepository.saveAndFlush(lotto4star);

	}
}
