Feature: Verify product information

Background:
	Given the user is on the home page
Scenario Outline:
	When the user selects "<product>"
	Then product page title should contain "<product>"
	And product name should be "<product>"
	
	Examples:
	|product			  |
	|Printed Summer Dress |
	|Printed Dress		  |
	
	
	@temp1
Scenario Outline:
	When the user selects "<product>"
	
	Examples:
	|product			  |
	|Printed Summer Dress |
	|Printed Dress		  |
	|Printed Summer Dress |
	
