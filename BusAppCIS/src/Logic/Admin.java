package Logic;

public class Admin extends Customer {
	
	// default constructor 
	public Admin() {
		
	}
	// lengthy constructor 
	public Admin(int id, int ssn, String firstName, String lastName, String email, String phone, String address,
			 String city, int zipCode, String state, String country, String userName, 
			 String password, String securityQuestion, String securityAnswer) {
		super(id, ssn, firstName, lastName, email, phone, address, city, zipCode, state, country, userName,
				password, securityQuestion, securityAnswer);
	}
	
	
	//edit user
	public void editUser() {
		
	}

	//update bus trips
	public void updateTrip() {
		
	}
	
	//remove trips
	public void deleteTrip() {
		
	}
	
	
}
