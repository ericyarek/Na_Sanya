Feature: Error messages on the login page


Scenario: Invalid email
	Given the user is on the login page
	When the user tries to register an ivalid email
	Then the system should dispaly error message "Invalid email address."
	
	
	Scenario: Blank email
	Given the user is on the login page
	When the user tries to register blank email
	Then the system should dispaly error message "Invalid email address."
	
	
	#@temp
	Scenario: existing email
		Given there is an existing user
		And the user is on the login page
		When the user tries to register the same email
		Then the system should dispaly error message "An account using this email address has already been registered. Please enter a valid password or request a new one."
	
	# blank email
	# existing email
	# how to search for a text in the eclipse ctrl+H