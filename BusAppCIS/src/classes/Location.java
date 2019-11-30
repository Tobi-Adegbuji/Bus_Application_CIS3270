package classes;



//repeat code!! busStation replaces this class


public class Location {

	private String cityName;
	private String stateName;
	private String cityAcronymn;
	
	
	// defualt location is Atlanta, Georgia
	public Location() {
		stateName = "Georgia";
		cityName = "Atlanta";
		cityAcronymn = "ATL";
	}
	
	public Location(String cityName, String stateName, String cityAcronymn) {
		this.cityName = cityName;
		this.stateName = stateName;
		this.cityAcronymn = cityAcronymn;
	}
	
	public String getCityName() {
		return this.cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getStateName() {
		return this.stateName;
	}
	
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public String getCityAcronymn() {
		return this.cityAcronymn;
	}
	
	public void setCityAcronymn(String cityAcronym) {
		this.cityAcronymn = cityAcronym;
	}
	
	@Override 
	public String toString() {
		return "State: " + this.stateName + "\n" +
				"City: " + this.cityName + "\n" +
				"City Acronymn: " + this.cityAcronymn;
	}
	
	
	
}
