Feature: Data Table 
@temp
Scenario: Invalid email using Data Table
	Given the user is on the login page
	When I enter invalid data on the page
| Fields                 | Values              |
| Email Address          | someone@someone.com |
| Password               | Password1           |

	Then the system should dispaly error message signIn "Authentication failed."