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
		String htmlExample = "<html><head></head><body><div>test</div></body></html>"
		String parsedResponse = responseParser.parse("")
	}

}
