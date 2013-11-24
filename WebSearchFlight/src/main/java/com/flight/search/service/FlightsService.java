package com.flight.search.service;

import java.util.List;

import com.flight.search.domain.SearchFlights;

public interface FlightsService {
	public List<SearchFlights> send(SearchFlights searchFlights);
}
