package com.flight.response;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLResponseParser {

	
	
	public String parse(String html){
		Document doc = Jsoup.parse(html.toString());
//		FileWriter fw = new FileWriter("C://temp//temp.html");
//		fw.write(html.toString());
		Elements prices = doc.select("div[class=singleItinerayPrice defaultWhiteText centerAlign]");
//		for (Element price : prices)
////			System.out.println(price.text());
		return prices.get(0).text();
	}
	
}
