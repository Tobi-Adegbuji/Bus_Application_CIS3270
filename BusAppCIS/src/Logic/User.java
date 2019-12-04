package Logic;

public abstract class User {

	 private String firstName, lastName, address, city, state, country,  
	userName, password, email, securityQuestion, securityAnswer; 
	
	 private int zipCode, ssn; 
	
	 private long phone;
	
	 User() { 
		
		 this.firstName = "firstName";
		 this.lastName = "lastName";
		 this.email = "testuser@fake.com";
		 this.phone = 404909000; //phone number is to long for data type long
		 this.ssn = 123456789;
		 this.address = "address";
		 this.city = "City";
		 this.zipCode = 92335;
		 this.state = "State";
		 this.country = "Country";
		 this.userName = "userName";
		 this.password = "password";
		 this.securityQuestion = "Security Question";
		 this.securityAnswer = "securityAnswer";
	
	 }
	 
	 User(int ssn, String firstName, String lastName, String email, int phone, String address,
			 String city, int zipCode, String state, String country, String userName, 
			 String password, String securityQuestion, String securityAnswer) { 
		 
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.email = email;
		 this.phone = phone;
		 this.ssn = ssn;
		 this.address = address;
		 this.city = city;
		 this.zipCode = zipCode;
		 this.state = state;
		 this.country = country;
		 this.userName = userName;
		 this.password = password;
		 this.securityQuestion = securityQuestion;
		 this.securityAnswer = securityAnswer;
		 
	 }
	 
	 public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSecurityQuestion() {
			return securityQuestion;
		}

		public void setSecurityQuestion(String securityQuestion) {
			this.securityQuestion = securityQuestion;
		}

		public String getSecurityAnswer() {
			return securityAnswer;
		}

		public void setSecurityAnswer(String securityAnswer) {
			this.securityAnswer = securityAnswer;
		}

		public Long getPhone() {
			return phone;
		}

		public void setPhone(Long phone) {
			this.phone = phone;
		}

		public int getZipCode() {
			return zipCode;
		}

		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}

		public int getSsn() {
			return ssn;
		}

		public void setSsn(int ssn) {
			this.ssn = ssn;
		}
	 
	 
	
}
