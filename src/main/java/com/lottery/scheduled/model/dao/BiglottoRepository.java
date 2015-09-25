package com.lottery.scheduled.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.lottery.scheduled.model.entity.*;

public interface BiglottoRepository extends JpaRepository<Biglotto, Integer> {

}
