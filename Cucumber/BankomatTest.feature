Feature: Make a bank withdrawl

Scenario: Withdraw 309 crowns with sufficient balance
	Given There is 500 crowns in my balance
	And I have logged in
	When I withdraw 309 crowns
	Then There is 191 crowns in my balance
	
Scenario: Insufficient balance
	Given There is 191 crowns in my balance
	And I have logged in
	When I withdraw 600 crowns
	Then There is an error
	And There is 191 crowns in my balance
	
Scenario: Check Balance
	Given There is 191 crowns in my balance
	And I have logged in
	When I push the balance button
	Then There is 191 crowns in my balance