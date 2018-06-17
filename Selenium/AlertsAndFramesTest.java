package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlertsAndFramesTest {
	AlertsAndFrames af = new AlertsAndFrames();
	@Test
	void testSearchSchools() {
		af.searchSchools();
		af.quitWebDriver();
	}

}
