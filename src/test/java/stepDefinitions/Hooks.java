package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void beforeScenario() throws IOException
	{
		StepDefinition m=new StepDefinition();
		if(StepDefinition.place_id==null)
		{	
		m.add_place_payload_with(79, "rani", "9865656001", "12 gandhi st", "www.google.com", "tamil");
		m.user_calls_using_post_http_request("AddPlaceAPI","Post");
		m.verify_place_id_created_to_map_using("rani", "GetPlaceAPI");
		} 
	}
}
