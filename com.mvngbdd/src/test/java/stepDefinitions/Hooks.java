package stepDefinitions;

import cucumber.api.java.*;

public class Hooks {
	@Before(order=1)
    public void beforeScenario(){
        System.out.println("Start the browser and Clear the cookies");
    } 
 @Before(order=0)
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    } 
 
 
 @After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    } 
 @After(order=1)
    public void afterScenario(){
        System.out.println("Log out the user and close the browser");
    } 

}
