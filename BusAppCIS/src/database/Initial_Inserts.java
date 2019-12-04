package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Initial_Inserts {

	public static void main(String[] args) {

		Connection con = SQLConnection.connector();
		
		Statement st; 
		
		String adminQuery = "insert into Admin" + 
				"(ssn" + 
				",firstName" + 
				",lastName" + 
				",email" + 
				",phone" + 
				",username" + 
				",password" + 
				",street" + 
				",city" + 
				",state" + 
				",country" + 
				",zip" + 
				",security_question" + 
				",security_answer" + 
				",id" + 
				")" + 
				"values" + 
				"(123456789" + 
				",'Admin'" + 
				",'User'" + 
				",'admin1@edgexpress.com'" + 
				",'1234567890'" + 
				",'admin'" + 
				",'admin'" + 
				",'edge xpress quarters'" + 
				",'Atlanta'" + 
				",'GA'" + 
				",'United States of America'" + 
				",'30000'" + 
				",'What is your first middle school?'" + 
				",'Brookwood'" + 
				",'0001'" + 
				")"; 
		
		try {
		
			st = con.createStatement();
			
			st.executeUpdate(adminQuery); 
			
			st.close();
			
			System.out.println("Complete");
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	
		
		
	}

}
