package com.lottery.scheduled.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lottery.scheduled.model.entity.V2Lotto3star;
import com.lottery.scheduled.model.entity.V2Lotto4star;
import com.lottery.scheduled.model.entity.V2LottoBig;
import com.lottery.scheduled.model.entity.V2LottoDafu;
import com.lottery.scheduled.model.entity.V2LottoPower;
import com.lottery.scheduled.model.entity.V2LottoToday;
import com.lottery.scheduled.obj.UdnResult;
import com.lottery.scheduled.utils.Http;

@Component
public class UDNparse {
	private String url = "http://udn.com/lotto/";

	@Autowired
	private Http http;
	
	/**
	 * 取得最新的開獎結果
	 * @return
	 */
	public UdnResult getNewParse(){
		UdnResult udnResult = new UdnResult();
		String html = http.get(url);

		Document document = Jsoup.parse(html);
		Elements table = document.select("#lottos");
		Elements list = table.select("> div");

		String[] titles = new String[] { "今彩", "威力彩", "大樂透", "三星彩", "四星彩", "大福彩" };
		ArrayList<Object> answer = new ArrayList<Object>();
		for (Element element : list) {
			for (String title : titles) {
				if (element.text().contains(title)) {
					String name = element.select("> h3").first().text().trim();
					String date = element.select("> div > h4").first().text().trim();
					String serial = date.substring(date.indexOf("第") + 1, date.indexOf("期")).trim();
					date = date.substring(0, date.indexOf("│")).trim();
					String year = date.split("/")[0].trim();
					String month = date.split("/")[1].trim();
					String day = date.split("/")[2].trim();
					Calendar calendar = Calendar.getInstance();
					calendar.set(Calendar.YEAR, Integer.parseInt(year));
					calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
					calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
					Elements temp = element.select("> div > b");
					Integer[] numbers = new Integer[temp.size()];
					for (int index = 0; index < numbers.length; index++) {
						numbers[index] = Integer.parseInt(temp.get(index).text().trim());
					}
					Date datetime = new Date(calendar.getTime().getTime());
					switch (title) {
					case "今彩": {
						Arrays.sort(numbers);
						V2LottoToday lottoToday = new V2LottoToday();
						lottoToday.setSerial(serial);
						lottoToday.setDate(datetime);
						lottoToday.setNumber01(numbers[0]);
						lottoToday.setNumber02(numbers[1]);
						lottoToday.setNumber03(numbers[2]);
						lottoToday.setNumber04(numbers[3]);
						lottoToday.setNumber05(numbers[4]);
						lottoToday.setWin01Count(-1);
						udnResult.setLottoToday(lottoToday);
						break;
					}
					case "威力彩": {
						Arrays.sort(numbers, 0, 6);
						V2LottoPower lottoPower = new V2LottoPower();
						lottoPower.setSerial(serial);
						lottoPower.setDate(datetime);
						lottoPower.setNumber01(numbers[0]);
						lottoPower.setNumber02(numbers[1]);
						lottoPower.setNumber03(numbers[2]);
						lottoPower.setNumber04(numbers[3]);
						lottoPower.setNumber05(numbers[4]);
						lottoPower.setNumber06(numbers[5]);
						lottoPower.setNumber07(numbers[6]);
						lottoPower.setWin01Count(-1);
						udnResult.setLottoPower(lottoPower);
						break;
					}
					case "大樂透": {
						Arrays.sort(numbers, 0, 6);
						V2LottoBig lottoBig = new V2LottoBig();
						lottoBig.setSerial(serial);
						lottoBig.setDate(datetime);
						lottoBig.setNumber01(numbers[0]);
						lottoBig.setNumber02(numbers[1]);
						lottoBig.setNumber03(numbers[2]);
						lottoBig.setNumber04(numbers[3]);
						lottoBig.setNumber05(numbers[4]);
						lottoBig.setNumber06(numbers[5]);
						lottoBig.setNumber07(numbers[6]);
						lottoBig.setWin01Count(-1);
						udnResult.setLottoBig(lottoBig);
						break;
					}
					case "四星彩": {
						V2Lotto4star lotto4star = new V2Lotto4star();
						lotto4star.setSerial(serial);
						lotto4star.setDate(datetime);
						lotto4star.setNumber01(numbers[0]);
						lotto4star.setNumber02(numbers[1]);
						lotto4star.setNumber03(numbers[2]);
						lotto4star.setNumber04(numbers[3]);
						udnResult.setLotto4Star(lotto4star);
						break;
					}
					case "三星彩": {
						V2Lotto3star lotto3star = new V2Lotto3star();
						lotto3star.setSerial(serial);
						lotto3star.setDate(datetime);
						lotto3star.setNumber01(numbers[0]);
						lotto3star.setNumber02(numbers[1]);
						lotto3star.setNumber03(numbers[2]);
						udnResult.setLotto3Star(lotto3star);
						break;
					}
					case "大福彩": {
						Arrays.sort(numbers);
						V2LottoDafu lottoDafu = new V2LottoDafu();
						lottoDafu.setSerial(serial);
						lottoDafu.setDate(datetime);
						lottoDafu.setNumber01(numbers[0]);
						lottoDafu.setNumber02(numbers[1]);
						lottoDafu.setNumber03(numbers[2]);
						lottoDafu.setNumber04(numbers[3]);
						lottoDafu.setNumber05(numbers[4]);
						lottoDafu.setNumber06(numbers[5]);
						lottoDafu.setNumber07(numbers[6]);
						lottoDafu.setWin01Count(-1);
						udnResult.setLottoDafu(lottoDafu);
						break;
					}
					}
				}
			}
		}
		return udnResult;
	}
}
