Feature: The mock should learn to respond to requests that I have not defined so that i do not have to add code for that manually

  Scenario: Learning to calculate addition.
    Given Mimicservice is up and running
    And Mimic has no learned requests
    When I "add" values 5 and 2 with answer 7
    And I "add" values 5 and 4 with answer 9
    And I "add" values 9 and 4 with answer 13
    And I ask for 5 "add" 30
    Then I get response "35"
    
    Scenario: Learning to calculate subtraction.
    Given Mimicservice is up and running
    And Mimic has no learned requests
    When I "sub" values 5 and 2 with answer 3
    And I "sub" values 5 and 4 with answer 1
    And I "sub" values 9 and 4 with answer 5
    And I ask for 35 "sub" 5
    Then I get response "30"
    
    Scenario: Learning to calculate division.
    Given Mimicservice is up and running
    And Mimic has no learned requests
    When I "div" values 6 and 2 with answer 3
    And I "div" values 10 and 2 with answer 5
    And I "div" values 10 and 5 with answer 2
    And I ask for 30 "div" 3
    Then I get response "10"
    
    Scenario: Learning to calculate multiply.
    Given Mimicservice is up and running
    And Mimic has no learned requests
    When I "mult" values 5 and 2 with answer 10
    And I "mult" values 5 and 5 with answer 25
    And I "mult" values 9 and 4 with answer 36
    And I ask for 5 "mult" 30
    Then I get response "150"
    
    
  Scenario: Learning to calculate subtraction with a negative answer.
    Given Mimicservice is up and running
    And Mimic has no learned requests
    When I "sub" values 5 and 2 with answer 3
    And I "sub" values 5 and 4 with answer 1
    And I "sub" values 9 and 4 with answer 5
    And I ask for 5 "sub" 35
    Then I get response "-30"
    
	Scenario: Learning to calculate division and divide by zero.
    Given Mimicservice is up and running
    And Mimic has no learned requests
    When I "div" values 6 and 2 with answer 3
    And I "div" values 10 and 2 with answer 5
    And I "div" values 10 and 5 with answer 2
    And I ask for 30 "div" 0
    Then I get response ""
    
	Scenario: Learning to calculate mulitply with characters that ends the same.
    Given Mimicservice is up and running
    And Mimic has no learned requests
    When I "mult" values 5 and 2 with answer 10
    And I "mult" values 5 and 4 with answer 20
    And I "mult" values 9 and 4 with answer 36
    And I ask for 5 "mult" 30
    Then I get response "150"