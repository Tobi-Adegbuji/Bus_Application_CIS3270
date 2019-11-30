package classes;

public class Customer extends User {

	private int id; 
	
	public Customer() {
		id = 12345678;
	}
	
	public Customer(int id, int ssn, String firstName, String lastName, String email, int phone, String address,
			 String city, int zipCode, String state, String country, String userName, 
			 String password, String securityQuestion, String securityAnswer) {
		super(ssn, firstName, lastName, email, phone, address, city, zipCode, state, country, userName,
				password, securityQuestion, securityAnswer);
		this.id = id;
		
		
	}
	
	public int getId() {
		return id;
	}
	
	
	
}
