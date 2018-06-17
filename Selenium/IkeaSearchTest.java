package selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class IkeaSearchTest {
	IkeaSearch iSearch;
	@Test
	void testSearch() {
		iSearch = new IkeaSearch();
		iSearch.goToUrl("https://www.ikea.com");
		iSearch.findByClass("gateway-header__cta");
		iSearch.clickOnElement();
		iSearch.findById("search");
		iSearch.clickClearAndSearch("Billy");
		iSearch.findById("txtNameProduct1");
		iSearch.clickOnElement();
		iSearch.delay(4000);
		iSearch.quitDriver();
	}
	@Test
	void testSearchLoop() {
		List<String> searchList = new ArrayList<String>();
		searchList.add("Billy");
		searchList.add("Delaktig");
		searchList.add("Stockholm");
		searchList.add("Bengt");
		searchList.add("Boröy");
		
		iSearch = new IkeaSearch();
		iSearch.goToUrl("https://www.ikea.com");
		iSearch.findByClass("gateway-header__cta");
		iSearch.clickOnElement();
		for(String s:searchList) {
			iSearch.findById("search");
			iSearch.clickClearAndSearch(s);
			iSearch.findById("txtNameProduct1");
			iSearch.clickOnElement();
			iSearch.findByIdAndClick("jsButton_saveToList_lnk");
			iSearch.findById("price1");
			iSearch.totalPrice(Integer.parseInt(iSearch.getElement().getText().replaceAll(" ", "").replaceAll("kr", "")));
			//iSearch.delay(2000);
		}
		System.out.println("Totala Priset för alla varor: "+iSearch.getTotalPrice()+" kr");
		iSearch.findByClassAndClick("shoppingList");
		for(int i = 0;i<searchList.size();i++) {
			iSearch.delay(2000);
			iSearch.findByLinkTextAndClick("Ta bort");
		}
		assertEquals(iSearch.getTotalPrice(), 18338);
		iSearch.quitDriver();
	}

}
