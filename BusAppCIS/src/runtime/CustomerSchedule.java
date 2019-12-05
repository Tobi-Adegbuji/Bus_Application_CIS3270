package runtime;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

//Still working on this

//We will most likely end up deleting a lot of the other classes in this package 

public class CustomerSchedule {

	
	private SimpleStringProperty fromStation, toStation;
	private int passengerNumber; 
	LocalDate arrivalDate, departureDate; 
	
	
	public static void main(String[] args) {
		
		System.out.println(LocalDate.now());
		
	}
	
	
	
}
