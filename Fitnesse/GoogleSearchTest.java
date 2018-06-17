package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GoogleSearchTest {

	@Test
	void test() {
		GoogleSearch gs = new GoogleSearch();
		gs.goToPage("https://www.google.se/");
		gs.findAndClearSearchbar();
		gs.search("SpaceX");
		String text = gs.findAndReturnFirstLink();
		assertEquals(text,"SpaceX");
		gs.quitWebDriver();
	}

}
