Feature: The state machine should remember its current state.

Scenario: Change state to ON
Given state is OFF
When 	set the state to ON
Then 	state is ON

Scenario: Change state to OFF
Given state is ON
When set the state to OFF
Then state is OFF

