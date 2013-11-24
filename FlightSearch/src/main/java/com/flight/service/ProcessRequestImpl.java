package com.flight.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.flight.request.HttpRequestSender;
import com.flight.response.HTMLResponseParser;
import com.flight.search.domain.SearchFlights;

public class ProcessRequestImpl implements ProcessRequest {
	public static HTMLResponseParser responseParser = new HTMLResponseParser();
	public static HttpRequestSender sender = new HttpRequestSender();

	public List<SearchFlights> processService(List<String> departureLocations,
			List<String> arrivalLocations, List<String> departureDates,
			List<String> returnDates) throws IOException {
		String response = "";
		// String flightKey = "";
		// FileWriter fw = new FileWriter("results.txt");
		int i = 1;
		List<SearchFlights> fs = new ArrayList<SearchFlights>();
		for (String dt : departureDates) {
			for (String rd : returnDates) {
				for (String ac : arrivalLocations) {
					for (String dc : departureLocations) {

						try {
							response = sender.sendRequestApache(dc, ac, dt, rd);
							String parsedResponse = responseParser.parse(response);
							fs.add(new SearchFlights(dt, dc, rd, ac, parsedResponse));
							// TODO: Refactore commented stuff
							// i++;
							// flightKey =
							// " Departure "+dc+" Arrival: "+ac+" Date "+dt;
							// fw.write(parsedResponse+" Departure "+dc+" Arrival: "+ac+" Date "+dt+" Number of request: "+i+"\n");
							// System.out.println("Number of request "+i+"::"+parsedResponse+" Departure "+dc+" Arrival Rio "+" Date "+dt);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		return fs;
	}
}
