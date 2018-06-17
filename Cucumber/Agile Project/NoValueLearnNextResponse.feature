Feature: Respond with a form when using the LearnNextResponse command without parameters

	Scenario: Giving the LearnNextResponse request in mimic
		Given Mimicservice is up and running
	  And Mimic has no learned requests
    When I give request "LearnNextResponse"
    Then I get response Form