Feature: Validating Place API
@Addplace
Scenario Outline: verify if place is being sucessfully added using AddPlaceAPI
	Given Add place payload with <accuracy> "<name>" "<phone_number>" "<address>" "<website>" "<language>"
	When user calls "AddPlaceAPI" using "post" Http Request
	Then The API call is Success with status code 200
	And validate "status" response body is "OK"
	And "scope" response body is "APP"
	And verify place id created to map "<name>" using "GetPlaceAPI"
	
Examples:
	| accuracy | name   | phone_number | address    | website        | language |
	| 50       | udhaya | 4694944729   | sundrop dr | www.google.com | english  |

@Deleteplace	
Scenario Outline: verify if delete functionality working using DeletePlaceAPI
	Given Delete place payload
	When user calls "DeletePlaceAPI" using "post" Http Request
	Then The API call is Success with status code 200
	And validate "status" response body is "OK"
