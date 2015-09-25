package com.lottery.scheduled.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lottery.scheduled.model.dao.BiglottoRepository;
import com.lottery.scheduled.model.entity.Biglotto;

@Service
@Transactional
public class BiglottoService {
	@Autowired
	private BiglottoRepository biglottoRepository;

	public List<Biglotto> findAll() {
		return biglottoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}
}
