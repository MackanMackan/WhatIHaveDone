package info.cukes.cucumber_junit;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StateMachineTest {
	public class InvalidStateException extends Exception {
	}

	private static StateMachine sm = new StateMachine();

	public StateMachineTest() {
	}

	@Given("^state is OFF$")
	public void state_is_OFF() throws Throwable {
		System.out.println("Is it Off? " + sm.isOff());
		if (!sm.isOff()) {
			throw new InvalidStateException();
		}
		// throw new PendingException();
	}
	@When("^set the state to (.*)$")
	public void set_the_state_to_ON(String stateOnOff) throws Throwable {
		if (stateOnOff.equalsIgnoreCase("on")) {
			sm.turnOn();
		}else {
			sm.turnOff();
		}
	}
/*
	@When("^set the state to ON$")
	public void set_the_state_to_ON() throws Throwable {
		if (sm.isOff()) {
			sm.turnOn();
		}
		// throw new PendingException();
	}
*/
	@Then("^state is ON$")
	public void state_is_ON() throws Throwable {
		System.out.println("Is it on? " + sm.isOn());
		if (!sm.isOn()) {
			throw new InvalidStateException();
		}
		// throw new PendingException();
	}
/*
	@When("^set the state to OFF$")
	public void set_the_state_to_OFF() throws Throwable {
	    if(!sm.isOff()) {
	    	sm.turnOff();
	    }
	}
*/
}
