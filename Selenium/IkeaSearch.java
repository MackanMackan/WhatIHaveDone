package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IkeaSearch {
	private WebDriver webDriver;
	private WebElement element;
	private int totalPrice;
	
	public IkeaSearch() {
		initWebDriver();
	}
	public void clickClearAndSearch(String searchword) {
		clickOnElement();
		element.clear();
		element.sendKeys(searchword);
		element.submit();
	}
	public void clickOnElement() {
		element.click();
	}
	public void totalPrice(int totalPrice) {
		this.totalPrice = this.totalPrice+totalPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public WebElement getElement() {
		return element;
	}
	public void findById(String id) {
		element = webDriver.findElement(By.id(id));
	}
	public void goToUrl(String URL) {
		webDriver.get(URL);
	}
	public void findByClass(String className) {
		element = webDriver.findElement(By.className(className));
	}
	private void initWebDriver() {
		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		webDriver = new ChromeDriver();
		totalPrice = 0;
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void findByIdAndClick(String id) {
		findById(id);
		clickOnElement();
	}
	public void findByClassAndClick(String className) {
		findByClass(className);
		clickOnElement();
	}
	public void findByLinkText(String linkText) {
		element = webDriver.findElement(By.linkText(linkText));
	}
	public void findByLinkTextAndClick(String linkText) {
		findByLinkText(linkText);
		clickOnElement();
	}
	public void quitDriver() {
		webDriver.quit();
	}
	public void delay(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
		}
	}
}
