package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.GoogleAddApi;
import pojo.Location;

public class TestDataBuild {

	
	public GoogleAddApi addPlacePayLoad(Integer accuracy, String name, String phone_number, String address, String website, String language)
	{
		GoogleAddApi addapi= new GoogleAddApi();
		
		addapi.setAccuracy(accuracy);
		addapi.setAddress(address);
		addapi.setName(name);
		addapi.setPhone_number(phone_number);
		addapi.setLanguage(language);
		addapi.setWebsite(website);
		List<String> typelist=new ArrayList<String>();
		typelist.add("shoe park");
		typelist.add("shoe");
		addapi.setTypes(typelist);
		
		Location location=new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		addapi.setLocation(location);	
		return addapi;
	}
	
	public String deletePlacePayLoad(String place_id)
	{
		
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
	}
}
