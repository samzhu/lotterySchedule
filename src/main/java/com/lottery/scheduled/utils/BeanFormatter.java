package com.lottery.scheduled.utils;

public class BeanFormatter {
	
	
	
	/**
	 * 期別-威力彩
	 * @param year
	 * @param index
	 * @return
	 */
	public static String formatRound(int year, int index) {
		return String.format("%03d", year) + String.format("%06d", index);
	}
}
