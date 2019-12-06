package entities;

public class Customer extends User {

	public Customer(int ssn, String firstName, String lastName, String email, String username, String password,
			String address, String city, String state, String country, String zip, String securityQuestion,
			String securityAnswer, String id, String adminAccess) {
		super(ssn, firstName, lastName, email, username, password, address, city, state, country, zip, securityQuestion,
				securityAnswer, id, adminAccess);
	}

//Getters and setters are already defined in super class 
	
	@Override
	public String toString() {
		
		return getFirstName() + " " + getLastName() + " " + getUsername() + " " + getSsn(); 
		
	}
	
	
	
}
