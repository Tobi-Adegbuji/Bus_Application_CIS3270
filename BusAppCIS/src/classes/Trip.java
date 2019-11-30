package classes;


public class Trip {

	private int tripNumber, numofPass, capacity;
	private String fromStation, toStation, departureDate, arrivalDate, 
	departureTime, arrivalTime;
	
	
	
	
	public Trip(int tripNumber, int capacity, int numofPass, String fromStation, String toStation, 
			String departureDate, String arrivalDate, String departureTime, String arrivalTime ) {
		
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.capacity = capacity;
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




	public int getCapacity() {
		return capacity;
	}




	public void setCapacity(int capacity) {
		this.capacity = capacity;
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




	public String getArrivalDate() {
		return arrivalDate;
	}




	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
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
	

	
	
	
	
	
}
