package Assignment;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps {
	private static CalculatorCaller cc = new CalculatorCaller();
	
	@Given("^I have started the calc$")
	public void i_have_started_the_calc() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^I use numbers (\\d+) and (\\d+)$")
	public void i_add_and(int arg1, int arg2) throws Throwable {
	    cc.assignValues(arg1, arg2);
	}

	@Then("^the result for (.*) is (\\d+)$")
	public void the_result_is(String function, int arg1) throws Throwable {
	    if(function.equalsIgnoreCase("adding")) {
	    	if(Integer.parseInt(cc.add())!=arg1) {
	    		throw new Exception();
	    	}
	    }else if(function.equalsIgnoreCase("dividing")) {
	    	if(Integer.parseInt(cc.div())!=arg1) {
	    		throw new Exception();
	    	}
	    }else if(function.equalsIgnoreCase("subtracting")) {
	    	if(Integer.parseInt(cc.sub())!=arg1) {
	    		throw new Exception();
	    	}
	    }else if(function.equalsIgnoreCase("multiplying")) {
	    	if(Integer.parseInt(cc.mult())!=arg1) {
	    		throw new Exception();
	    	}
	    }
	}
}
