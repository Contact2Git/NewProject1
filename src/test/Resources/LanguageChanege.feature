#Author: Ramesh 
Feature:Currency Conversion

 @SmokTest 
  Scenario: Language and Region change on the home page 
    Given user is on home page 
    And User Change the language and region  
    And user enter search item internationpayments in serch box 
    When user hits search icon     
    Then system displays the internationalpayments page 
    
    
