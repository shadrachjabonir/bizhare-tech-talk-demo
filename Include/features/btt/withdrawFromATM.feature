#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Account has sufficient amount

  @tag1
  Scenario Outline: Account has sufficient amount
    Given the account <accountNumber> balance is <initBalance>
		And the card <accountNumber> is valid
		And the ATM <atmNumber> contains enough money
		When the Account Holder <accountNumber> <atmNumber> requests <amount>
		Then the ATM should dispense <amount>
		And the account <accountNumber> balance should be <balance>
		And the card <accountNumber> should be returned <cardReturn>

    Examples: 
      | accountNumber  | atmNumber | amount  | balance | cardReturn | initBalance |
      | 001    				 | atm1      | 10 		 | 90      | true       | 100         |
      | 001    				 | atm1      | 10 		 | 80      | true       | 90          |
      | 001    				 | atm1      | 10 		 | 70      | true       | 80  		    |
      | 001    				 | atm1      | 10 		 | 60      | true       | 70  		    |
      | 001    				 | atm1      | 10 		 | 50      | true       | 60  		    | 
      
      