package com.flight.service;

import java.io.IOException;
import java.util.List;

import com.flight.search.domain.SearchFlights;

public interface ProcessRequest {
	public List<SearchFlights> processService(List<String> departureLocation0, List<String> arrivalLocation0, List<String> departureDate0, List<String> returnDate) throws IOException;
}