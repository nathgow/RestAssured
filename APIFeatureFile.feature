
Feature: API
  


  Scenario: API for foreign Exchange
    Given API for foreign exchange <http://ratesapi.io/documentation/> 
		When posted with correct Information
		Then validate positive response code received


  
