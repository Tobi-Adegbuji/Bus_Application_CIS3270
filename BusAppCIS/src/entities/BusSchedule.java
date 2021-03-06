package entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.property.SimpleStringProperty;

//Still working on this


public class BusSchedule {

	//Declaring Private attributes
	private SimpleStringProperty fromStation, toStation, numberOfPassengers, capacity, scheduleID, arrivalTime, departureTime;
; 
	private Date arrivalDate, departureDate;
	
	
	
	//Bus Schedule Constructor
	public BusSchedule(String fromStation, String toStation,
			Date arrivalDate, Date departureDate, String arrivalTime, String departureTime
			, String numberOfPassengers, String capacity, String scheduleID) {
		//to removed shadowing error this. is used 
		this.fromStation = new SimpleStringProperty(fromStation);
		this.toStation = new SimpleStringProperty(toStation);
		this.numberOfPassengers = new SimpleStringProperty(numberOfPassengers);
		this.arrivalDate = arrivalDate;
		this.capacity = new SimpleStringProperty(capacity); 
		this.departureDate = departureDate;
		this.arrivalTime = new SimpleStringProperty(arrivalTime);
		this.departureTime = new SimpleStringProperty(departureTime);
		this.scheduleID = new SimpleStringProperty(scheduleID);
		
		
	}



	//Get From Station
	public String getFromStation() {
		return fromStation.get();
	}



	//Set from Station
	public void setFromStation(SimpleStringProperty fromStation) {
		this.fromStation = fromStation;
	}



	// Get to station
	public String getToStation() {
		return toStation.get();
	}



	// Set To Station
	public void setToStation(SimpleStringProperty toStation) {
		this.toStation = toStation;
	}



	// get number of passengers
	public String getNumberOfPassengers() {
		return numberOfPassengers.get();
	}



	// set number of passengers
	public void setNumberOfPassengers(int passengerNumber) {
		this.numberOfPassengers = numberOfPassengers;
	}



	// get arrival date
	public Date getArrivalDate() {
		return arrivalDate;
	}



	// set arrival date
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}



	// get departure date
	public Date getDepartureDate() {
		return departureDate;
	}



	// set departure date
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}



	// get arrival time
	public String getArrivalTime() {
		return arrivalTime.get();
	}



	// set arrival time
	public void setArrivalTime(SimpleStringProperty arrival_time) {
		this.arrivalTime = arrival_time;
	}



	// get departure time
	public String getDepartureTime() {
		return departureTime.get();
	}



	// set departure time
	public void setDepartureTime(SimpleStringProperty departure_time) {
		this.departureTime = departure_time;
	}



	// get capacity
	public String getCapacity() {
		return capacity.get();
	}



	// set capacity
	public void setCapacity(SimpleStringProperty capacity) {
		this.capacity = capacity;
	} 
	
	// get Schedule ID
	public String getScheduleID() {
		return scheduleID.get();
	}



	//Set Schedule ID
	public void setScheduleID(SimpleStringProperty scheduleID) {
		this.scheduleID = scheduleID;
	} 
	
	
		
}