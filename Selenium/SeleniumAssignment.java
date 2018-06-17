package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment {
	
	private WebDriver webDriver;
	
	public SeleniumAssignment() {
		initWebDriver();
	}
	
	
	private void initWebDriver() {
		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void goToPage(String page) {
		webDriver.get(page);
	}
	public void chooseTravelRoute(String startPoint, String destination) {
		/*chooseStartStation(startPoint);
		chooseDestination(destination);*/
		WebElement element1 = webDriver.findElement(By.className("from-station-dropdown"));
		WebElement element2 = webDriver.findElement(By.className("to-station-dropdown"));
		
		element1.click();
		element1 = webDriver.findElement(By.linkText(startPoint));
		if(checkStartPoint(startPoint,element1)) {
		element1.click();
		}
		
		element2.click();
		element2 = webDriver.findElement(By.linkText(destination));
		if(checkStopDestination(destination,element2)) {
		element2.click();
		}
	}
	public void clickSearchAndAddTickets(int tickets) {
		tickets--;
		WebElement element = webDriver.findElement(By.className("search-btn"));
		element.click();
		element = webDriver.findElement(By.className("add"));
		for(int i=0;i<tickets;i++) {
			element.click();
		}
	}
	public int getTickets() {
		WebElement element = webDriver.findElement(By.className("paxlabel"));
		int tickets = Integer.parseInt(element.getText().replaceAll(" Vuxna", ""));
		return tickets;
	}
	
	private boolean checkStartPoint(String startPoint, WebElement element) {
		return element.getText().equals(startPoint);
	}
	private boolean checkStopDestination(String destination, WebElement element) {
		return element.getText().equals(destination);
	}
	public void quitSelenium() {
		webDriver.quit();
	}
	public void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

