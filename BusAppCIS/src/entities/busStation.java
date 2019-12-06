package entities;

public class busStation {

	private String cityName;
	private String stateName;
	private String cityAcronymn;
	
	// default location is Atlanta, Georgia
	public busStation() {
		stateName = "Georgia";
		cityName = "Atlanta";
		//City Acronym can be used as ID for bus stations since it is unique (only one busStation per city)
		cityAcronymn = "ATL";
	}
	
	public busStation(String cityName, String stateName, String cityAcronymn) {
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
