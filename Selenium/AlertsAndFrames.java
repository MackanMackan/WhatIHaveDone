package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsAndFrames {
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	public AlertsAndFrames() {
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		webDriver = new ChromeDriver();
		wait = new WebDriverWait(webDriver, 10);
	}
	public void searchSchools() {
		webDriver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		String myWindowHandler = webDriver.getWindowHandle();
		delay(2000);
		webDriver.switchTo().frame("iframeResult");
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));//getButton("button");
		button.click();
		delay(1000);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = webDriver.switchTo().alert();
		delay(1000);
		alert.accept();
		delay(1000);
		webDriver.switchTo().window(myWindowHandler);

	}
	public void quitWebDriver() {
		webDriver.quit();
	}
	public void delay(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
		}
	}
	public WebElement getButton(String cssPath) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssPath)));
	}
}
