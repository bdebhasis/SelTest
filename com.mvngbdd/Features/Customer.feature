Feature: Customer details

Background: Login in Application
Given User Launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on the Login


Scenario: Add new Customer 1st
Then User can view the Dashboard
When User click on customers Menu
And click on customers Menu Item
And Click on Add New button
Then user can view Add new Customer page
When User enter Customer info
And Click on the Save button
Then User can view confirmation message "The new customer has been added successfully"
And Close the Browser



Scenario: Add new Customer 2nd
Then User can view the Dashboard
When User click on customers Menu
And click on customers Menu Item
And Click on Add New button
Then user can view Add new Customer page
When User enter Customer info
And Click on the Save button
Then User can view confirmation message "The new customer has been added successfully"
And Close the Browser