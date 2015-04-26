package be.odisee.pajottertest;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class TestTelerUpdate extends SeleneseTestCase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testTestTelerUpdate() throws Exception {
		selenium.open("/Pajotters/home.html");
		selenium.click("//a[contains(text(),'Teler1\n		                        Achternaam1')]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Bewerk teler");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=vnaam", "Teler2");
		selenium.type("id=fnaam", "Achternaam2");
		selenium.type("id=email", "teler.telermans@telers.be");
		selenium.type("id=adres", "Telerstraat 13, Tealvoorde");
		selenium.type("id=telefoon", "9876543210");
		selenium.type("id=pwoord", "telertjes");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Teler2", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[2]/td[2]"));
		verifyEquals("Achternaam2", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[3]/td[2]"));
		verifyEquals("teler.telermans@telers.be", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[4]/td[2]"));
		verifyEquals("Telerstraat 13, Tealvoorde", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[5]/td[2]"));
		verifyEquals("9876543210", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[6]/td[2]"));
		verifyEquals("telertjes", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[7]/td[2]"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Teler2 Achternaam2", selenium.getText("//a[contains(text(),'Teler2\n		                        Achternaam2')]"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
