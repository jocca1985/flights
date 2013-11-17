package com.flight.request;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.flight.request.HttpRequestSender;

public class HttpRequestSenderTest {
	private HttpRequestSender sender; 
	
	@Before
	public void setUp() throws Exception {
		sender = new HttpRequestSender();
	}

	@Test
	public void testSendRequest() throws IOException {
//		String response = sender.sendRequestApache();
//		assertNotNull(response);
	}

}
