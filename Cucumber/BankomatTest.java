package bankomat;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BankomatTest {
	Bankomat b = new Bankomat();
	
	@Given("^There is (\\d+) crowns in my balance$")
	public void there_is_crowns_in_my_balance(int arg1) throws Throwable {
	    if(b.showMyBalance()!=arg1) {
	    	throw new Exception("Balance differ from actual"+b.showMyBalance());
	    }
	}

	@Given("^I have logged in$")
	public void i_am_logged_in() throws Throwable {
	    b.logIn(1234);
	}

	@When("^I withdraw (\\d+) crowns$")
	public void i_withdraw_crowns(int arg1) throws Throwable {
	    b.bankWithdrawl(arg1);
	}

	@Then("^There is an error$")
	public void there_is_an_error() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
	@When("^I push the balance button$")
	public void i_push_the_balance_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

}
