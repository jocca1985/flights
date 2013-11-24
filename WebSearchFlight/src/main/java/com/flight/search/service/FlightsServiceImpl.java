package com.flight.search.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.flight.search.domain.SearchFlights;
import com.flight.service.ProcessRequestImpl;

public class FlightsServiceImpl implements FlightsService {
	private ProcessRequestImpl sender;

	@Override
	public List<SearchFlights> send(SearchFlights searchFlights) {
		String departureLocation0 = searchFlights.getAirportDepartureName();
		String arrivalLocation0 = searchFlights.getAirportArrivalName();
		String departureDate0 = searchFlights.getDepartureDate();
		String returnDate = searchFlights.getAirportArrivalName();
		
		List<SearchFlights> response = new ArrayList<SearchFlights>();
		try {
			List<String> departureLocations = new ArrayList<String>();
			departureLocations.add(departureLocation0);
			List<String> arrivalLocations = new ArrayList<String>();
			arrivalLocations.add(arrivalLocation0);
			List<String> departureDates = new ArrayList<String>();
			departureDates.add(departureDate0);
			List<String> returnDates = new ArrayList<String>();
			returnDates.add(returnDate);
			response = sender.processService(departureLocations, arrivalLocations, departureDates, returnDates);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public void setProcessRequestImpl(ProcessRequestImpl sender) {
		this.sender = sender;
	}

}
