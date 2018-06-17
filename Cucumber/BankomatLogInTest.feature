Feature: Logging in with pin

Scenario: Logging in
	Given I am logged out
	When I enter my pin: 1234
	Then I am logged in
	
	Scenario: Using wrong pin
	Given I am logged out
	When I enter wrong pin: 1111
	Then I am logged out