###################################################################
# 2018	       				          	  	  #
# IT-Högskolan projektarbete grupp 3		 	   	  #
# Nancy-Anne Delaney, Joakim Gustavsson, Marcus Kolbe, Lotta Berg #
###################################################################

package MimicServiceProject.MimicService;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MimicSelenium {

	private WebDriver webDriver;
	private final static String host="http://localhost:8080/"; 
	private HttpServiceCaller service=new HttpServiceCaller();
	
	public MimicSelenium() {
		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		webDriver=new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * Start a webpage
	 * @param url
	 */
	public void goToPage(String url){
		webDriver.get(url);
		delay(3000);
	}
	
	/**
	 * Learn the Mimic a new request and response with one variable and with the form and click learn button.
	 * @param text
	 */
	public void learn(String text) {
		WebElement element=webDriver.findElement(By.name("text"));
		element.click();
		element.clear();
		element.sendKeys(text);	
		WebElement button=webDriver.findElement(By.cssSelector(("#learn"))); 
		button.click();
		delay(3000);
	}
	
	/**
	 * Verify the response in the form
	 * @param expectedResponse
	 */
	public boolean checkResponse(String expectedResponse) {	
		WebElement element=webDriver.findElement(By.cssSelector("pre"));
		String text=element.getText();
		return text.contains(expectedResponse);
	}
	
	/**
	 * Get response from message pages
	 * @param expectedResponse
	 */
	public boolean checkResponse_message(String expectedResponse) {	
		WebElement element = webDriver.findElement(By.tagName("body"));
		String text=element.getText();
		return text.contains(expectedResponse);
	}
	
	/**
	 * Relearn a new response to the request using command syntax
	 * @param text
	 */
	public void relearnResponse(String text) {
		webDriver.get(host+"relearnResponse");
		delay(3000);
		WebElement element=webDriver.findElement(By.name("text"));
		element.click();
		element.clear();
		element.sendKeys(text);	
		WebElement button=webDriver.findElement(By.cssSelector(("#learn"))); 
		button.click();
		delay(3000);
	}
	
	/**
	 * Unlearn a response to the request using command syntax
	 */
	public void unlearnResponse() {
		webDriver.get(host+"unlearnResponse");
		delay(3000);
		//closeBrowser();
	}
	
	/**
	 * Verify the response in message page after unlearn method call
	 * @param expectedUnlearnedResponse
	 */
	public boolean checkUnlearn(String expectedUnlearnedResponse) {	
		WebElement element=webDriver.findElement(By.cssSelector("body"));
		String text=element.getText();
		return text.contains(expectedUnlearnedResponse);
	}
	
	/**
	 * Reset all states using the command syntax
	 */
	public void resetState(){
		String requestToSend=host+"resetState";
		goToPage(requestToSend);
		}
	
	public void delay (int milliseconds) {

		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}

	}
	
	public void closeBrowser() {
		webDriver.close();
		delay(3000);
	}
	
	public void quitSelenium() {
		webDriver.quit();
	}

	/**
	 * Get list of requests and states using command syntax
	 */
	public String viewRequests() {
		WebElement element;
		goToPage(host+"viewRequests");
		element = webDriver.findElement(By.tagName("body"));
		return element.getText();			
	}
	
	/**
	 * Calling the http command addResponse, to get the form.
	 */
	public void addResponse() {
		goToPage(host+"addResponse");
	}
	
	/**
	 * Delete all requests responses
	 */
	public void unlearnAllRequests() {
		goToPage(host+"unlearnAllResponses");
	}
	
	/**
	 * Find and click on element ID 
	 * @param id
	 */
	public void clickById(String id) {
		WebElement element;
		element = webDriver.findElement(By.id(id));
		element.click();
		delay(3000);
	}
	/**
	 * chooses mime-type in the drop-down list.
	 * @param xpath
	 */
	public void chooseMimeType(String xpath) {
		WebElement element;
		element = webDriver.findElement(By.name("mime"));
		element.click();
		element = webDriver.findElement(By.xpath(xpath));
		element.click();
	}
	/**
	 * Finds an element by ID and returns an element as a string
	 * @param id
	 * @return
	 */
	public String getTextById(String id) {
		WebElement element;
		element = webDriver.findElement(By.id(id));
		return element.toString();
	}
	/**
	 *  Returns the current URL as a string
	 * @return
	 */
	public String getUrl() {
		return webDriver.getCurrentUrl();
	}
}
