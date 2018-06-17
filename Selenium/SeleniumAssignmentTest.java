package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeleniumAssignmentTest {
	SeleniumAssignment sa = new SeleniumAssignment();
	@Test
	void testCheckTickets() {
		sa.goToPage("https://mtrexpress.se/sv");
		sa.chooseTravelRoute("Skövde", "Alingsås");
		sa.clickSearchAndAddTickets(3);
		assertEquals(sa.getTickets(),3);
		sa.quitSelenium();

	}

}
