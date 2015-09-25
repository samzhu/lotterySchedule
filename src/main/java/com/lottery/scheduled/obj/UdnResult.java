package com.lottery.scheduled.obj;

import lombok.Data;

import com.lottery.scheduled.model.entity.*;

@Data
public class UdnResult {
	public V2LottoToday lottoToday;
	public V2LottoPower lottoPower;
	public V2LottoBig lottoBig;
	public V2Lotto3star lotto3Star;
	public V2Lotto4star lotto4Star;
	public V2LottoDafu lottoDafu;
}
