package com.main.flight.response;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HTMLResponseParserTest {
	private HTMLResponseParser responseParser;
	
	@Before
	public void setUp() throws Exception {
		responseParser = new HTMLResponseParser();
	}

	@Test
	public void test() {
	//	fail("Not yet implemented");
		String htmlExample = "<html><head></head><body><div class=\"singleItinerayPrice defaultWhiteText centerAlign\">13</div></body></html>";
		String parsedResponse = responseParser.parse(htmlExample); 
		System.out.println(parsedResponse);
	}

}
