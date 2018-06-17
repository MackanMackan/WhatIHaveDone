Feature: As a Tester I would like the mock to unlearn all responses so that I can rerun all the tests without restarting the service



	Scenario Outline: Learning multiple req/resp and verify it unlearn all
	
		Given Mimicservice is up and running
		And has learned request "Banana" and response "Skids"
		And has learned request "Laurel" and response "Hardy"
		And has learned request "Ful" and response "Bil"
		When I use unlearnAll command
		And I give request <request>
		Then I get response Form
		
		Examples:
		|	request 	|
		| "Banana"	|
		| "Laurel"	|
		| "Ful"			|