package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearch {
	
private WebDriver webDriver;
private WebElement element;
	
	public GoogleSearch() {
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
	public void findAndClearSearchbar() {
		element = webDriver.findElement(By.id("lst-ib"));
		element.clear();
	}
	public void search(String searchWord) {	
		element.click();
		element.sendKeys(searchWord);
		element.sendKeys(Keys.ENTER);
	}
	public String findAndReturnFirstLink() {
		//String css = "body.srp.tbo.vasq:nth-child(2) div.mw:nth-child(12) div.col:nth-child(2) div.med:nth-child(2) div._NId:nth-child(2) div.srg div.g:nth-child(1) div:nth-child(1) div.rc h3.r > a:nth-child(1)";
		String xpath = "//div[@id='search']/div/div/div/div/div/div[1]/div/div/h3/a";
		element = webDriver.findElement(By.xpath(xpath));
		//element = webDriver.findElement(By.cssSelector(css));
		return element.getText();
	}
	public void quitWebDriver() {
		webDriver.quit();
	}
}
