package com.flight.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flight.search.domain.SearchFlights;
import com.flight.service.ProcessRequestImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProcessRequestImpl sender;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		 model.addAttribute("searchFlights", new  SearchFlights ());
		return "home";
	}
	
	@RequestMapping(value = "searchFlights", method = RequestMethod.POST)
	public String searchFlights(@ModelAttribute("searchFlights") SearchFlights searchFlights, Model model) {
		List<SearchFlights> response = send(searchFlights);
		logger.info(searchFlights.toString());
		model.addAttribute("flightResponse",response);
		return "home";
	}
	
	private List<SearchFlights> send(SearchFlights searchFlights) {
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
