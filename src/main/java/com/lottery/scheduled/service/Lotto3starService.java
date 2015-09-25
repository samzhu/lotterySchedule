package com.lottery.scheduled.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.scheduled.model.dao.*;
import com.lottery.scheduled.model.entity.*;

@Service
@Transactional
public class Lotto3starService {

	@Autowired
	private V2Lotto3starRepository V2Lotto3starRepository;

	public V2Lotto3star findByID(String serial){
		return V2Lotto3starRepository.findOne(serial);
	}


	public V2Lotto3star save(V2Lotto3star lotto3star){
		return V2Lotto3starRepository.saveAndFlush(lotto3star);
	}
}