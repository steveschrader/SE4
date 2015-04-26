package be.odisee.pajottertest;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class TestTelerVerwijderen extends SeleneseTestCase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testTestTelerVerwijderen() throws Exception {
		selenium.open("/Pajotters/home.html");
		selenium.click("//a[contains(text(),'Teler2\n		                        Achternaam2')]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Verwijder teler");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Welkom in de Pajottersapplicatie", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
