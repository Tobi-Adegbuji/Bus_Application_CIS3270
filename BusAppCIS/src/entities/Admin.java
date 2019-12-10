package entities;

public class Admin extends Customer {

	//constructor
	public Admin(int ssn, String firstName, String lastName, String email, String username, String password,
			String address, String city, String state, String country, String zip, String securityQuestion,
			String securityAnswer, String id, String adminAccess) {
		//parent constructor
		super(ssn, firstName, lastName, email, username, password, address, city, state, country, zip, securityQuestion,
				securityAnswer, id, adminAccess);
	}
	
	//Getters and setters are defined in super class
	
	
	
}
