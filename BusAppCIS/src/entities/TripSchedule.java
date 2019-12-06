package entities;


public class TripSchedule {

	private int tripNumber, numofPass; 
	private String fromStation, toStation, departureDate,  
	departureTime, arrivalTime, bus;
	
	
	
	
	public TripSchedule(int tripNumber, int numofPass, String fromStation, String toStation, 
			String departureDate, String departureTime, String arrivalTime, String bus ) {
		
		this.arrivalTime = arrivalTime;
		this.bus = bus; 
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.fromStation = fromStation;
		this.numofPass = numofPass;
		this.toStation = toStation;
		this.tripNumber = tripNumber;
		
	}




	public int getTripNumber() {
		return tripNumber;
	}




	public void setTripNumber(int tripNumber) {
		this.tripNumber = tripNumber;
	}




	public int getNumofPass() {
		return numofPass;
	}




	public void setNumofPass(int numofPass) {
		this.numofPass = numofPass;
	}


	public String getFromStation() {
		return fromStation;
	}




	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}




	public String getToStation() {
		return toStation;
	}




	public void setToStation(String toStation) {
		this.toStation = toStation;
	}




	public String getDepartureDate() {
		return departureDate;
	}




	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}



	public String getDepartureTime() {
		return departureTime;
	}




	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}




	public String getArrivalTime() {
		return arrivalTime;
	}




	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}




	public String getBus() {
		return bus;
	}




	public void setBus(String bus) {
		this.bus = bus;
	}
	

	
	
	
	
	
}
