package com.main.flight.http.request;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.main.flight.http.request.HttpRequestSender;

public class HttpRequestSenderTest {
	private HttpRequestSender sender; 
	
	@Before
	public void setUp() throws Exception {
		sender = new HttpRequestSender();
	}

	@Test
	public void testSendRequest() throws IOException {
		String url = new String("http://www.edreams.com/engine/ItinerarySearch/search");
		//String response = sender.sendRequest(url );
		String response = sender.sendRequestApache();
		assertNotNull(response);
	}

}
