Feature: Control the elevator

Scenario: Go to floor 3
	Given Elevator is on floor 1
	And Elevator is closed
	When Floorbutton 3 is pressed
	And Elevator is on floor 3 
	And Elevator should be open
	
	Scenario: Go to unexisting floor 6
	Given Elevator is on floor 1
	And Elevator is closed
	When Floorbutton 6 is pressed
	And Elevator is on floor 6
	And Elevator should be open
	
	Scenario: Go to unexisting floor 0
	Given Elevator is on floor 1
	And Elevator is closed
	When Floorbutton 0 is pressed
	And Elevator is on floor 0
	And Elevator should be open