package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetBit{
	
  
	
	public void retrieveBit() {
		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		WebDriver webDriver=new ChromeDriver();
		webDriver.get("https://www.bt.cx");
		String bitbuy1 ="";
		String bitsell1="";
		delay(1000);
		WebElement element = webDriver.findElement(By.id("buy-price-sek"));
		bitbuy1 = element.getText();
		delay(6000);
		WebElement element2 = webDriver.findElement(By.id("sell-price-sek"));
		bitsell1 = element2.getText();
		
		webDriver.get("https://safello.com/buy");
		element = webDriver.findElement(By.className("price-ticker"));
		String bitbuy2 = element.getText();
		webDriver.get("https://safello.com/sell");
		element = webDriver.findElement(By.className("price-ticker"));
		String bitsell2 = element.getText();
		System.out.println("BTCX: Bit k�p: "+bitbuy1+" Bit s�lj: "+bitsell1);
		System.out.println("Safello: Bit k�p: "+bitbuy2+" Bit s�lj: "+bitsell2);
		webDriver.quit();
	}
	public void delay(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
		}
	}
}
