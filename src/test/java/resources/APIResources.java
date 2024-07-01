package resources;

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	PutPlaceAPI("maps/api/place/update/json");
	
	private String resources;
	
	APIResources(String resources)
	{
		this.resources=resources;
	}
	
	public String getResources()
	{
		return resources;
	}
}
