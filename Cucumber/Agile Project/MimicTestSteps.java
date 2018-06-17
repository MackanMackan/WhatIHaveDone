package MimicServiceProject.MimicService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MimicTestSteps {
	private MimicCaller mc = new MimicCaller();
	private String result;
	
	@Given("^Mimicservice is up and running$")
	public void mimicservice_is_up_and_running() throws Throwable {
	if  (Runtime.getRuntime().exec("java -jar /Users/Marcu/Desktop/Skola/Automatisering/Projektarbete/sprint5/mimic.jar") != null);	
	 // System.out.println("MimicService up-n-running");
	}
	@Given("^has learned request \"([^\"]*)\" and response \"([^\"]*)\"$")
	public void has_learned_request_and_response(String arg1, String arg2) throws Throwable {
//	result = mc.setRequest(host+"LearnNextResponse?text" +arg1+" =" +arg2);
	mc.learnNewRequest(arg1, arg2);
	}
	@Given("^Mimic has no learned requests$")
	public void mimic_has_no_learned_requests() throws Throwable {
		mc.unlearnAllRequests();
	}
	@When("^I give request \"([^\"]*)\"$")
	public void i_give_request(String arg1) throws Throwable {
	result = mc.getResponse(arg1);
	}
	@When("^I use unlearn command$")
	public void i_use_unlearn_command() throws Throwable {
	mc.unlearnResponse();
	} 
	@When("^I use unlearnAll command$")
	public void i_use_unlearnAll_command() throws Throwable {
	    mc.unlearnAllRequests();
	}
	@When("^I KillMimic$")
	public void i_KillMimic() throws Throwable {
	   mc.killMimic();
	   Thread.sleep(5000);
	}

	@When("^Start Mimic$")
	public void start_Mimic() throws Throwable {
	    mc.startMimic();
	}
	@When("^I \"([^\"]*)\" values (\\d+) and (\\d+) with answer (\\d+)$")
	public void i_values_and_and(String arg1, int arg2, int arg3, int arg4) throws Throwable {
		mc.learnEquation(arg1, arg2, arg3, arg4);
	}
	@When("^I ask for (\\d+) \"([^\"]*)\" (\\d+)$")
	public void i_ask_for(int arg1, String arg2, int arg3) throws Throwable {
	    result = mc.sendMathRequest(arg1, arg2, arg3);
	}
	@When("^I resetState$")
	public void i_resetState() throws Throwable {
	    mc.resetState();
	}
	@Then("^I get response \"([^\"]*)\"$")
	public void i_get_response(String arg1) throws Throwable {
		//System.out.println(result+" = "+arg1);
		if (!result.equals(arg1)) {
			throw new Exception();
		}
	}
	@Then("^I get response Form$")
	public void i_get_response_NULL() throws Throwable {
		System.out.println("Result= "+ result);
		if (!result.contains("json")) {
			throw new Exception();
		}
	}
}
