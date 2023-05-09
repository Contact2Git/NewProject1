#Author: Ramesh 
Feature:Currency Conversion 

 @sometest 
  Scenario: Title of your scenario
    Given user is on Currency conversion page 
	#And user move to menu Maintain currencies and      selects maintain currencies rates option
    And user selects country from currency I have dropdown 
    And user select coungry from currency I want dropdown 
    And user input amount in Amount I have dropdown 
    #When user click on convert button 
    Then system displays currency in user want 
