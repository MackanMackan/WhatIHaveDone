package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestGoogleSearch {
	/**
	 * Performs a Google Search
	 * @param searchText
	 */
	@Test
	void testGoogleSearch() {
	
		GoogleSearch gs = new GoogleSearch();
		gs.search("iths");
		gs.clickLinkByLinkText("IT-Högskolan Göteborg");
		gs.asserTitle("IT-Högskolan Göteborg");
		gs.clickLinkByLinkText("Läs mer om IT-Högskolans samarbetspartners");
		gs.quitWebDriver();
		
	}
	/**
	 * Performs a Google Image Search
	 * @param searchText
	 */
	@Test
	void testGoogleImageSearch() {
		
		GoogleSearch gs = new GoogleSearch();
		gs.searchImage("Banana");
		gs.clickLinkByName("MJ3vCbAJoQ7PkM:");
		gs.quitWebDriver();
	}
	@Test
	void testWiki() {
		GoogleSearch gs = new GoogleSearch();
		gs.searchWiki("Eminem");
		gs.quitWebDriver();
	}

}
