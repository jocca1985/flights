package com.main.flight.response;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.main.flight.http.request.HttpRequestSender;

public class HTMLResponseParserTest {
	private HTMLResponseParser responseParser;
	private HttpRequestSender sender; 
	@Before
	public void setUp() throws Exception {
		responseParser = new HTMLResponseParser();
		sender = new HttpRequestSender();
	}

	@Test
	public void test() {
	//	fail("Not yet implemented");
		String url = new String("http://www.edreams.com/engine/ItinerarySearch/search");
		//String response = sender.sendRequest(url );
		String response = "";
		try {
			response = sender.sendRequestApache();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String htmlExample = response;
		String parsedResponse = responseParser.parse(htmlExample); 
		System.out.println(parsedResponse);
	}

}
