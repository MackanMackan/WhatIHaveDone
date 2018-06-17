package bankomat;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BankomatLogInTest {
	Bankomat b = new Bankomat();

	@Given("^I am logged (.*)$")
	public void i_am_logged_out_or_in(String logged) throws Throwable {
		if(logged.equalsIgnoreCase("out")) {
			if(b.isLoggedIn()) {
				throw new Exception();
			}
		}else {
			if(!b.isLoggedIn()) {
				throw new Exception();
			}
		}
	}

	@When("^I enter my pin: (\\d+)$")
	public void i_enter_my_pin(int pin) throws Throwable {
	    b.logIn(pin);
	}

	@When("^I enter wrong pin: (\\d+)$")
	public void i_enter_wrong_pin(int pin) throws Throwable {
	    b.logIn(pin);
	}
}
