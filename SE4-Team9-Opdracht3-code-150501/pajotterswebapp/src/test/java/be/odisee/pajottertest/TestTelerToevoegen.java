package be.odisee.pajottertest;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

@SuppressWarnings("deprecation")
public class TestTelerToevoegen extends SeleneseTestCase {
	
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testTestTelerToevoegen() throws Exception {
		selenium.open("/Pajotters/");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Teler Toevoegen");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=vnaam", "Teler1");
		selenium.type("id=fnaam", "Achternaam1");
		selenium.type("id=email", "teler.achternaam@telers.be");
		selenium.type("id=adres", "Telerstraat 13t, Telergem");
		selenium.type("id=telefoon", "0123456789");
		selenium.type("id=pwoord", "telertje");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Teler1", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[2]/td[2]"));
		verifyEquals("Achternaam1", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[3]/td[2]"));
		verifyEquals("teler.achternaam@telers.be", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[4]/td[2]"));
		verifyEquals("Telerstraat 13t, Telergem", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[5]/td[2]"));
		verifyEquals("0123456789", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[6]/td[2]"));
		verifyEquals("telertje", selenium.getText("//div[@id='Inhoud']/table/tbody/tr[7]/td[2]"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Teler1 Achternaam1", selenium.getText("//a[contains(text(),'Teler1\n		                        Achternaam1')]"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
