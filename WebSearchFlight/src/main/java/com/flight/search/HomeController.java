package com.flight.search;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flight.search.domain.SearchFlights;
import com.flight.search.service.FlightsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private FlightsService flightsService;
	
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
	public String searchFlights(@ModelAttribute("searchFlights") SearchFlights searchFlights) {
		String response = flightsService.send(searchFlights);
		logger.info(searchFlights.toString());
		return "home";
	}
	
}
