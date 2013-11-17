package com.flight.console;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.flight.request.HttpRequestSender;
import com.flight.response.HTMLResponseParser;

public class Main {

 public static HTMLResponseParser responseParser  =new HTMLResponseParser();
 public static HttpRequestSender sender = new HttpRequestSender(); 
	

	public static void main(String[] args) throws IOException {
	//	fail("Not yet implemented");
		String url = new String("http://www.edreams.com/engine/ItinerarySearch/search");
		//String response = sender.sendRequest(url );
		String response = "";
		List<String> departureCities = new ArrayList<String>();
		departureCities.add("Frankfurt");
		departureCities.add("Brussels");
		departureCities.add("Madrid");
		departureCities.add("Budapest");
		List<String> arrivalCities = new ArrayList<String>();
		arrivalCities.add("Rio de Janeiro");
		arrivalCities.add("Buenos Aires");
		arrivalCities.add("Lima");
		arrivalCities.add("Sao Paulo");
		List<String> dates = new ArrayList<String>();
		dates.add("01/02/2014");
		dates.add("02/02/2014");
		dates.add("03/02/2014");
		dates.add("04/02/2014");
		dates.add("05/02/2014");
		dates.add("06/02/2014");
		dates.add("07/02/2014");
		dates.add("08/02/2014");
		dates.add("09/02/2014");
		dates.add("10/02/2014");
		dates.add("11/02/2014");
		dates.add("12/02/2014");
		dates.add("13/02/2014");
		dates.add("14/02/2014");
		dates.add("15/02/2014");
		dates.add("16/02/2014");
		String returnDate = "15/03/2014";
		String parsedResponse = "";
		String flightKey = "";
		FileWriter fw = new FileWriter("results.txt");
		Map<String,Double> flightPrices = new HashMap<String, Double>();
		System.out.println("Number of requests:"+dates.size()*arrivalCities.size()*departureCities.size());
		int i=1;
		for(String dt:dates){
			for(String ac:arrivalCities){
				for(String dc:departureCities){
		try {
			response = sender.sendRequestApache(dc, ac, dt, returnDate);
			parsedResponse = responseParser.parse(response); 
			i++;
			flightKey = " Departure "+dc+" Arrival: "+ac+" Date "+dt;
			flightPrices.put(flightKey, Double.parseDouble(parsedResponse.replace("€,", "")));
			
			fw.write(parsedResponse+" Departure "+dc+" Arrival: "+ac+" Date "+dt+" Number of request: "+i+"\n");
			System.out.println("Number of request "+i+"::"+parsedResponse+" Departure "+dc+" Arrival Rio "+" Date "+dt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}
			}
		}
		Map.Entry<String, Double> maxEntry = null;

		for (Map.Entry<String, Double> entry : flightPrices.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) < 0)
		    {
		        maxEntry = entry;
		    }
		}
		System.out.println("The best price is "+maxEntry);
	}

}
