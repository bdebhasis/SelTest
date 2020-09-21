Feature: Login

Scenario: Sucessful Login with Valid Credentials
Given User Launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on the Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on the Log out Link
Then Page Title should be "Your store. Login"
And Close the Browser


Scenario Outline: Login Data Driven
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<uname>" and Password as "<pwd>"
	And Click on the Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on the Log out Link
	Then Page Title should be "Your store. Login"
	And Close the Browser
	
	Examples:
		|uname | pwd |
		|admin@yourstore.com | admin |
		|admins@yourstore.com | admins|