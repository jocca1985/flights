package com.flight.search.domain;

public class SearchFlights {
		private String departureDate; 	
		private String airportDepartureName; 	
		private String arrivalDate; 	
		private String airportArrivalName;
		
		
		@Override
		public String toString() {
			return "SearchFlights [departureDate=" + departureDate
					+ ", airportDepartureName=" + airportDepartureName
					+ ", arrivalDate=" + arrivalDate + ", airportArrivalName="
					+ airportArrivalName + "]";
		}
		public String getDepartureDate() {
			return departureDate;
		}
		public void setDepartureDate(String departureDate) {
			this.departureDate = departureDate;
		}
		public String getAirportDepartureName() {
			return airportDepartureName;
		}
		public void setAirportDepartureName(String airportDepartureName) {
			this.airportDepartureName = airportDepartureName;
		}
		public String getArrivalDate() {
			return arrivalDate;
		}
		public void setArrivalDate(String arrivalDate) {
			this.arrivalDate = arrivalDate;
		}
		public String getAirportArrivalName() {
			return airportArrivalName;
		}
		public void setAirportArrivalName(String airportArrivalName) {
			this.airportArrivalName = airportArrivalName;
		}
}
