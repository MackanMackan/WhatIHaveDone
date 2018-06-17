Feature: Functions Add,Divide,Subtracting,Mulitiply

Scenario: Adding
	Given I have started the calc
	When I use numbers 2 and 5
	Then the result for adding is 7
	
Scenario: Dividing
	Given I have started the calc
	When I use numbers 6 and 2
	Then the result for dividing is 3
	
Scenario: Subtracting
	Given I have started the calc
	When I use numbers 7 and 5
	Then the result for subtracting is 2
	
Scenario: Mulitplying
	Given I have started the calc
	When I use numbers 5 and 5
	Then the result for multiplying is 25
	
	