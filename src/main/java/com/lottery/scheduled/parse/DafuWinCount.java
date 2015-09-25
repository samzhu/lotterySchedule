package com.lottery.scheduled.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lottery.scheduled.utils.Http;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

/**
 * 大福彩-中獎注數(彩券網頁)
 * @author samzhu
 *
 */

@Component
public class DafuWinCount {
	private String url = "http://www.taiwanlottery.com.tw/Lotto/Lotto740/history.aspx";
	
	@Autowired
	private Http http;
	
	public Integer parser(String round){
		Integer wincount = null;
		try {
			String html = http.get(url);
			Document doc = Jsoup.parse(html);
			
			Element input = doc.select("input[id=__VIEWSTATE]").first();
			String viewstate = input.attr("value");

			input = doc.select("input[id=__EVENTVALIDATION]").first();
			String eventvalidation = input.attr("value");
			
			RequestBody formBody = new FormEncodingBuilder()
			.add("__EVENTTARGET", "")
			.add("__EVENTARGUMENT", "")
			.add("__LASTFOCUS", "")
			.add("__VIEWSTATE", viewstate)
			.add("__EVENTVALIDATION", eventvalidation)
			.add("SuperLotto638Control_history1$DropDownList1", "11")
			.add("SuperLotto638Control_history1$chk", "radNO")
			.add("SuperLotto638Control_history1$txtNO", round)
			.add("SuperLotto638Control_history1$btnSubmit", "查詢")
			.build();

			html = http.postForm(url, formBody);
			doc = Jsoup.parse(html);
			
			String win = doc.select("#Lotto740Control_history_dlQuery_L740_CategA3_0").text().trim();
			if(win.length() != 0){
				wincount = Integer.parseInt(win);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wincount;
	}
	
	public static void main(String[] args) throws Exception {
		
	}
}
