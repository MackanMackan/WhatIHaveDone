package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {
	
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	public GoogleSearch() {
		//System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		//webDriver = new ChromeDriver();
		try {
			webDriver = new RemoteWebDriver(new URL("http://localhost:8080/wd/hub"),DesiredCapabilities.chrome());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(webDriver, 30);
	}

		public void search(String searchWord) {
			
			webDriver.get("https://www.google.com");
			WebElement elementSearchBar = webDriver.findElement(By.id("lst-ib"));
			elementSearchBar.clear();
			elementSearchBar.click();
			elementSearchBar.sendKeys(searchWord);
			//elementSearchBar.submit();
			elementSearchBar.sendKeys(Keys.ENTER);
		}
		
		public void searchImage(String searchWord) {
			
			webDriver.get("https://www.google.com");
			WebElement elementSearchBar = webDriver.findElement(By.id("lst-ib"));
			elementSearchBar.clear();
			elementSearchBar.click();
			elementSearchBar.sendKeys(searchWord);
			elementSearchBar.submit();
			webDriver.findElement(By.linkText("Bilder")).click();
			
		}
		public void searchWiki(String searchWord) {
			webDriver.get("https://www.wikipedia.org");
			WebElement elementSearchBar = webDriver.findElement(By.id("searchInput"));
			elementSearchBar.clear();
			elementSearchBar.click();
			elementSearchBar.sendKeys(searchWord);
			//elementSearchBar.submit();
			elementSearchBar.sendKeys(Keys.ENTER);
		}
		public void quitWebDriver() {
			webDriver.quit();
		}
		public void clickLinkByLinkText(String linkText) {
			WebElement element = wait.until(ExpectedConditions.
					elementToBeClickable(By.linkText(linkText)));
			//WebElement element2=webDriver.findElement(By.linkText(linkText));
			element.click();
		}
		public void asserTitle(String assertText) {
			assertEquals(webDriver.getTitle(),assertText);
		}
		public void clickLinkByName(String name) {
			WebElement element = wait.until(ExpectedConditions.
					elementToBeClickable(By.name(name)));
			element.click();
		}
		public void delay(int milli) {
			try {
				Thread.sleep(milli);
			} catch (InterruptedException e) {
			}
}
}