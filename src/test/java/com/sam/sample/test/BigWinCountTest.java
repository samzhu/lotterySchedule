package com.sam.sample.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.lottery.scheduled.utils.Http;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

public class BigWinCountTest {

	public static void main(String[] args) {
		String round = "104000081";
		String url = "http://www.taiwanlottery.com.tw/lotto/Lotto649/history.aspx";
		Integer wincount = null;
		Http http = new Http();
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
			.add("SuperLotto638Control_history1$DropDownList1", "2")
			.add("SuperLotto638Control_history1$chk", "radNO")
			.add("SuperLotto638Control_history1$txtNO", round)
			.add("SuperLotto638Control_history1$btnSubmit", "查詢")
			.build();

			html = http.postForm(url, formBody);
			doc = Jsoup.parse(html);
			
			String win = doc.select("#Lotto649Control_history_dlQuery_L649_CategA3_0").text().trim();
			if(win.length() != 0){
				wincount = Integer.parseInt(win);
			}
			System.out.println("wincount = " + wincount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
