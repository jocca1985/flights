package com.flight.search.service;

import java.io.IOException;

import com.flight.request.HttpRequestSender;
import com.flight.search.domain.SearchFlights;

public class FlightsServiceImpl implements FlightsService {
	private HttpRequestSender sender;

	@Override
	public String send(SearchFlights searchFlights) {
		String departureLocation0 = searchFlights.getAirportDepartureName();
		String arrivalLocation0 = searchFlights.getAirportArrivalName();
		String departureDate0 = searchFlights.getDepartureDate();
		String returnDate = searchFlights.getAirportArrivalName();
		
		String response = "";
		try {
			response = sender.sendRequestApache(departureLocation0, arrivalLocation0, departureDate0, returnDate);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public void setSender(HttpRequestSender sender) {
		this.sender = sender;
	}

}
