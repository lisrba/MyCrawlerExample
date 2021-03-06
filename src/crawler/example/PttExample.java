package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 *
 */
public class PttExample {
	// commit test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481392387.A.CA1.html";

//		System.out.print(
//                CrawlerPack.start().addCookie("over18","1").getFromHtml(uri)
//                // 這兒開始是 Jsoup Document 物件操作
//                .select(".f3.hl.push-userid").text() //找推噓文帳號
//                //.select("div.push > span") //找推噓文div下的第一層span
//                //.select("div.push + span") //找跟推噓文div同層的span-->編輯記錄
//                //.select("div.push ~ div") //看所有推噓文
//                //.select("[type]")
//                //.select(".push-tag:contains(推) ~ span") //找推文資訊
//        );

				Document content = CrawlerPack.start()

				// 參數設定
			    .addCookie("over18","1") // 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼

				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
				.getFromHtml(uri);
			    //.getFromXml(uri)

				for (Element elem : content.select("#main-content *")) {
					elem.remove();
				}
                System.out.print(content.select("#main-content").text());
	}
}
