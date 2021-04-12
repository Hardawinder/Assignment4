package application;

public class FlightInformation {
	private String Airline;
	private String numberOfAirline;
	public String getAirline() {
		return Airline;
	}
	public void setAirline(String airline) {
		Airline = airline;
	}
	public String getNumberOfAirline() {
		return numberOfAirline;
	}
	public void setNumberOfAirline(String numberOfAirline) {
		this.numberOfAirline = numberOfAirline;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public FlightInformation(String airline, String numberOfAirline, String arrival, String departure) {
		super();
		Airline = airline;
		this.numberOfAirline = numberOfAirline;
		this.arrival = arrival;
		this.departure = departure;
	}
	private String arrival;
	private String departure;

}
