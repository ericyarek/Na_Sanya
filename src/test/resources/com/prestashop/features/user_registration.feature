Feature: Users should be able to login


Scenario: User registration
	Given the user is on the login page
	And the user enters a random email
	And the user enters personal information
	|First Name| Kunnka     |
	|Last Name | Admiral    |
	|City	   | Anytown 	|
	|Address   | 123 Main St|
	|Company   | Volvo      |
	
	 
Scenario: Custom User registration
	Given the user is on the login page
	And the user enters a random email
	And the user enters user information
	|First Name| Last Name     |City   |Address         |Company|
	| Admiral	   | Kunnka      |Anytown|123 Main St     |Volvo  |
	

	
	# code below not implemented	 
Scenario: user info
	Then correct user info should be displayed
		|First Name	   |Last Name     |City   |Address         |Company|
		|Admiral	   |Kunnka        |Anytown|123 Main St     |Volvo  |
		|Admiralw	   |Kunnka        |Anytown|123 Main St     |Volvo  |
		|Admirals	   |Kunnka        |Anytown|123 Main St     |Volvo  |
	And I login as this user
	|First Name| Last Name|
	| Admiral   |Kunnka  |
	And I order these
	|name| count| size |
	|dress	   |123  |M |
	|dress	   |123  |M |
	|tshirt	   |1 |M |