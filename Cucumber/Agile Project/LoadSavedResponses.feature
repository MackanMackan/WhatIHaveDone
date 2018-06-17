Feature: Mimic saves responses in a brain file

	Scenario Outline: Add multiple request with multiple responses, then killMimic 
	and start again to see that they are still there.
	
	Given Mimicservice is up and running
  And Mimic has no learned requests
  And has learned request "Banana" and response "Skids"
  And has learned request "Banana" and response "Fruit"
	And has learned request "Laurel" and response "Hardy"
	And has learned request "Laurel" and response "Bengt"
	And has learned request "Ful" and response "Bil"
	And has learned request "Ful" and response "Kul"
	When I KillMimic
	And Start Mimic
	And I give request <request>
	And I give request <request>
	Then I get response <response>
	
	Examples:
	|	request	|	response	|
	|	"Banana"|	"Fruit"	|
	|	"Laurel"	|	"Bengt"		|
	|	"Ful"		|	"Kul"			|
	
	Scenario: Add multiple request with multiple responses, then killMimic 
	and start again to see that they are still there and it remembers the state is was on when killed.
	
	Given Mimicservice is up and running
  And Mimic has no learned requests
  And has learned request "Banana" and response "Skids"
  And has learned request "Banana" and response "Fruit"
  And has learned request "Banana" and response "Fruit"
  And I give request "Banana"
  And I give request "Banana"
	When I KillMimic
	And Start Mimic
	And I give request "Banana"
	Then I get response "Fruit"
	