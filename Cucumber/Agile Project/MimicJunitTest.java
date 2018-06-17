package MimicServiceProject.MimicService;

import static org.junit.Assert.*;

import org.junit.Test;

public class MimicJunitTest {
	MimicSelenium mimic = new MimicSelenium();
	
	
	public void testStartMimic() {
			try {
				mc.startMimic();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	//@Test
	public void testRequestWithoutResponse() {
		mimic.goToPage("http://localhost:8080/request_without_response");
		mimic.learn("");
		mimic.goToPage("http://localhost:8080/request_without_response");
		assertTrue(mimic.checkResponse("")); //Det ska bli grönt
		mimic.closeBrowser();
	}


	//@Test
	public void testResponseWithoutRequest() {
		mimic.unlearnAllRequests();
		mimic.goToPage("http://localhost:8080");
		mimic.learn("Resp_utan_Req");
		mimic.goToPage("http://localhost:8080");
		assertTrue(mimic.checkResponse("Resp_utan_Req")); //Det ska bli grönt
		mimic.closeBrowser();
	}	
	
	//@Test
	public void testResetStateParalellSequences() {
		mimic.unlearnAllRequests();
		mimic.goToPage("http://localhost:8080/Number");
		mimic.learn("1");
		mimic.goToPage("http://localhost:8080/LearnNextResponse?text=2");
		mimic.goToPage("http://localhost:8080/Number");
		
		mimic.goToPage("http://localhost:8080/LearnNextResponse?text=3");
		mimic.goToPage("http://localhost:8080/Number");
		
		mimic.goToPage("http://localhost:8080/Number");
		mimic.goToPage("http://localhost:8080/Number");
		mimic.goToPage("http://localhost:8080/Number");
		mimic.goToPage("http://localhost:8080/Month");
		mimic.learn("January");
		mimic.goToPage("http://localhost:8080/LearnNextResponse?text=February");
		mimic.goToPage("http://localhost:8080/Month");
		mimic.goToPage("http://localhost:8080/Month");
		mimic.goToPage("http://localhost:8080/Month");
		
		mimic.goToPage("http://localhost:8080/Number");
		
		mimic.resetState();
		mimic.goToPage("http://localhost:8080/Number");
		assertTrue(mimic.checkResponse("1")); //Det ska bli grönt
		mimic.goToPage("http://localhost:8080/Month");
		assertTrue(mimic.checkResponse("January")); //Det ska bli grönt
		mimic.closeBrowser();
	}
	
	//@Test
	public void testMoveStatesMultSeq() {
		mimic.goToPage("http://localhost:8080/Number");
		assertTrue(mimic.checkResponse("2")); //Det ska bli grönt
		mimic.goToPage("http://localhost:8080/Month");
		assertTrue(mimic.checkResponse("February")); //Det ska bli grönt
		mimic.closeBrowser();
	}
	
	//@Test
	public void testParalellSequencesUnlearn() {
		mimic.unlearnAllRequests();
		mimic.goToPage("http://localhost:8080/Number");
		mimic.learn("1");
		mimic.goToPage("http://localhost:8080/LearnNextResponse?text=2");
		mimic.goToPage("http://localhost:8080/Number");
		
		mimic.goToPage("http://localhost:8080/LearnNextResponse?text=3");
		mimic.goToPage("http://localhost:8080/Number");
		
		mimic.goToPage("http://localhost:8080/Number");
		mimic.goToPage("http://localhost:8080/Number");
		mimic.goToPage("http://localhost:8080/Number"); //Number är på state 3 nu
		
		mimic.goToPage("http://localhost:8080/Month");
		mimic.learn("January");
		mimic.goToPage("http://localhost:8080/LearnNextResponse?text=February");
		mimic.goToPage("http://localhost:8080/Month");
		mimic.goToPage("http://localhost:8080/Month");
		mimic.goToPage("http://localhost:8080/Month"); // Month är på state 2 (February) nu
		
		mimic.goToPage("http://localhost:8080/Number");
		
		mimic.unlearnResponse();
		mimic.goToPage("http://localhost:8080/Number");
		assertTrue(mimic.checkResponse("2")); //Fel! den visar "3"
		mimic.goToPage("http://localhost:8080/Month");
		assertTrue(mimic.checkResponse("February")); //Förmodligen fel men kommer inte dit.
		mimic.closeBrowser();
	}
	
	//@Test
	public void testRelearn() {
		mimic.goToPage("http://localhost:8080/Number");
		mimic.learn("One");
		mimic.relearn("2");
		mimic.goToPage("http://localhost:8080/relearnResponse");
		mimic.goToPage("http://localhost:8080/Number");
		assertTrue(mimic.checkUnlearn("Paste or type json"));
		mimic.closeBrowser();
	}
	public void testViewRequest() {
		mimic.unlearnAllRequests();
		mimic.goToPage("http://localhost:8080/Number");
		mimic.learn("One");
		mimic.addRequest();
		mimic.learn("Two");
		mimic.addRequest();
		mimic.learn("Three");
		System.out.println(mimic.viewRequests());
		assertTrue(mimic.viewRequests().equals("GET /Number\n" + 
				"GET /Number\n" + 
				"GET /Number"));
		mimic.closeBrowser();
	public void testHtml() {
		mimic.unlearnAllRequests();
		mimic.goToPage("http://localhost:8080/Links");
		mimic.chooseMimeType("/html/body/form/select/option[4]");
		mimic.learn("<html>\n" + 
				"<body>\n" + 
				"<a id=\"hey\" href=\"Hey\">Say Hey!</a><br> \n" + 
				"<a id=\"you\" href=\"Youtube\">RickRoll</a><br>\n" + 
				"</body>\n" + 
				"</html>");
		mimic.goToPage("http://localhost:8080/Hey");
		mimic.chooseMimeType("/html/body/form/select/option[4]");
		mimic.learn("<html>\n" + 
				"<body>\n" + 
				"<h1> HEEEEEY! </h1>" + 
				"<a id=\"links\" href=\"Links\">Back to Links</a><br>\n" + 
				"</body>\n" + 
				"</html>");
		mimic.goToPage("http://localhost:8080/Youtube");
		mimic.chooseMimeType("/html/body/form/select/option[4]");
		mimic.learn("<html>\n" + 
				"<body>\n" + 
				"<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/dQw4w9WgXcQ\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>\n" + 
				"<a id=\"links\" href=\"Links\">Back to Links</a><br>\n" + 
				"</body>\n" + 
				"</html>");
		mimic.goToPage("http://localhost:8080/Links");
		mimic.clickById("hey");
		mimic.clickById("links");
		mimic.clickById("you");
		mimic.clickById("links");
		mimic.closeBrowser();
	}
	//@Test
	public void testJson() {
		mimic.unlearnAllRequests();
		mimic.goToPage("http://localhost:8080/monthly?TotalCost=2525&Months=5");
		mimic.chooseMimeType("/html/body/form/select/option[2]");
		mimic.learn("{\n" + 
				"“TotalCost” : 2525,\n" + 
				"“Months” : 5,\n" + 
				"“MonthlyCost” : 505\n" + 
				"}");
		mimic.goToPage("http://localhost:8080/monthly?TotalCost=666&Months=3");
		mimic.chooseMimeType("/html/body/form/select/option[2]");
		mimic.learn("{\n" + 
				"“TotalCost” : 666,\n" + 
				"“Months” : 3,\n" + 
				"“MonthlyCost” : 222\n" + 
				"}");
		mimic.goToPage("http://localhost:8080/monthly?TotalCost=4044&Months=12");
		assertTrue(mimic.checkResponse("{\n" + 
				"“TotalCost” : 4044,\n" + 
				"“Months” : 12,\n" + 
				"“MonthlyCost” : 337\n" + 
				"}"));
		mimic.closeBrowser();
	}
	//@Test
	public void testXml() {
		mimic.unlearnAllRequests();
		mimic.goToPage("http://localhost:8080/xml");
		mimic.chooseMimeType("/html/body/form/select/option[3]");
		mimic.learn("<note>\n" + 
				"<to>Tove</to>\n" + 
				"<from>Jani</from>\n" + 
				"<heading>Reminder</heading>\n" + 
				"<body>Don't forget me this weekend!</body>\n" + 
				"</note>");
		mimic.goToPage("http://localhost:8080/xml");
		assertTrue(mimic.getTextById("webkit-xml-viewer-source-xml").contains("xml"));
		mimic.closeBrowser();
	}
		@Test 
		public void testOKMessageLearnNextResponse() {
			mimic.unlearnAllRequests();
			mimic.goToPage("http://localhost:8080/LearnNextResponse?text=2");
			assertFalse(mimic.checkResponse_message("OK"));
			mimic.closeBrowser();
			}
		
		@Test
		public void testOKMessageUnlearnResponse() {
			mimic.unlearnAllRequests();
			mimic.goToPage("http://localhost:8080/Letter");
			mimic.learn("A");
			mimic.goToPage("http://localhost:8080/Letter");
			mimic.unlearnResponse();
			assertFalse(mimic.checkResponse_message("OK"));
			mimic.closeBrowser();
			}

		@Test 
		public void testOKMessageUnlearnAllResponses() {
			mimic.unlearnAllRequests();
			mimic.goToPage("http://localhost:8080/Letter");
			mimic.learn("A");
			mimic.addResponse();
			mimic.learn("B");
			mimic.goToPage("http://localhost:8080/LearnNextResponse?text=May");
			mimic.goToPage("http://localhost:8080/Month");
			mimic.unlearnAllRequests();
			assertFalse(mimic.checkResponse_message("OK"));
			mimic.closeBrowser();
			}
		
		@Test
		public void testOKMessageResetState() {
			mimic.unlearnAllRequests();
			mimic.goToPage("http://localhost:8080/Letter");
			mimic.learn("A");
			mimic.goToPage("http://localhost:8080/Letter");
			mimic.addResponse();
			mimic.learn("B");
			mimic.goToPage("http://localhost:8080/Letter");
			mimic.addResponse();
			mimic.learn("C");
			mimic.resetState();
			assertFalse(mimic.checkResponse_message("OK"));
			mimic.closeBrowser();
			}	

		@Test
		public void testOKMessageKillMimic() {
			mimic.unlearnAllRequests();
			mimic.goToPage("http://localhost:8080/Letter");
			mimic.learn("A");
			mimic.addResponse();
			mimic.learn("B");
			mimic.goToPage("http://localhost:8080/LearnNextResponse?text=May");
			mimic.goToPage("http://localhost:8080/Month");
			mimic.goToPage("http://localhost:8080/KillMimic");
			assertFalse(mimic.checkResponse_message("OK"));
			mimic.delay(8000);
			try {
				mc.startMimic();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mimic.closeBrowser();
			}
		//@Test
		public void testAutoDetect() {
			mimic.unlearnAllRequests();
			mimic.goToPage("http://localhost:8080/Links");
			mimic.learn("<html>\n" + 
					"<body>\n" + 
					"<a id=\"hey\" href=\"Hey\">Say Hey!</a><br> \n" + 
					"<a id=\"you\" href=\"Youtube\">RickRoll</a><br>\n" + 
					"</body>\n" + 
					"</html>");
			mimic.goToPage("http://localhost:8080/Links");
			try {
				mimic.clickById("hey");
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("AutoDetect ain't workin'");
			}finally {
				mimic.closeBrowser();
			}
		}
		//@Test
		public void testLongPath() {
			mimic.unlearnAllRequests();
			mimic.goToPage("http://localhost:8080/test/text//");
			mimic.learn("text");
			mimic.goToPage("http://localhost:8080/Numbers");
			assertTrue(mimic.getUrl().equals("http://localhost:8080/Numbers"));
			mimic.closeBrowser();
		}
	
	@Test
	public void testOrder1() { testRelearn();}
	public void testOrder2() { testResetStateParalellSequences(); testMoveStatesMultSeq();} 
	public void testOrder3() { testParalellSequencesUnlearn();}
	public void testOrder4() { testJson(); testViewRequest(); testLinksToRequests(); mimic.quitSelenium();}
	public void testOrder5() { testOKMessageLearnNextResponse(); testOKMessageUnlearnResponse();testOKMessageUnlearnAllResponses(); testOKMessageResetState(); testOKMessageKillMimic();}
}
