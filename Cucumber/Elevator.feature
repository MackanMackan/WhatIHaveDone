Feature: Elevator open/close doors

Scenario: Close elevator doors
	Given Elevator is open
	When I push a floor button
	Then Elevator should be closed

Scenario: Open elevator doors
	Given Elevator is closed
	When I push a floor button
	And Arrive at my floor
	Then Elevator should be open