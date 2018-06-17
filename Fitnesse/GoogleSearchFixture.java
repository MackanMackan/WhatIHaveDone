package assignment;

public class GoogleSearchFixture {
	
	public String search;
	
	public void setSearch(String search) {
		this.search = search;
	}
	public String searchAndReturnFirstLink() {
		GoogleSearch gs = new GoogleSearch();
		gs.goToPage("https://www.google.se/");
		gs.findAndClearSearchbar();
		gs.search(search);
		String text = gs.findAndReturnFirstLink();
		gs.quitWebDriver();
		return text;
	}
	
}
