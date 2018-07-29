Feature: Product details


Scenario: Verify producs on home page
	Given the user is on the home page
	Then the user should be able to see "Printed Summer Dress"
	
	
Scenario: Verify producs on home page
	Given the user is on the home page
	Then the user should be able to see following products
			|Printed Summer Dress  		  |
			|Printed Chiffon Dress  	  |
			|Blouse  					  |
			|Printed Dress  			  |
			|Faded Short Sleeve T-shirts  |
			
			
Scenario: Verify all sies
	Given the user is on the home page
	When the user selects "Printed Summer Dress"
	Then the product be available in the following sizes
			|S|
			|M|
			|L|
	#And correct default count size should be
			