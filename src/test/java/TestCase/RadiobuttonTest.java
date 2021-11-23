package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import BaseClass.BrowserSetup;
import PageObjectRepository.RadiobuttonPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RadiobuttonTest {
	
	static WebDriver driver;
	RadiobuttonPage rbp;
	UtilFile util;
	Alert alert;
	String displaymessage;
	static Properties prop;
	static FileInputStream fileInput;
	static File file = new File(System.getProperty("user.dir") + "\\config\\file.properties");
	
	
	@Before
	public void Configuration(){
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Given("^I go to Radio button$")
	public void i_go_to_Radio_button() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
		rbp = new RadiobuttonPage(driver);
		rbp.Radiobutton();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		
	   
	}

	@When("^I click on Impressive$")
	public void i_click_on_Impressive() throws Throwable {
		util = new UtilFile(driver);
		util.pause(2000);
		rbp.Impressiveradiobtn();
	}

	@Then("^the message 'You have selected Impressive' shall be shown$")
	public void the_message_You_have_selected_Impressive_shall_be_shown() throws Throwable {
	displaymessage = rbp.DisplayImpressive();
	   System.out.println("display message : " +displaymessage);
	}

	@Then("^I verify the message 'You have selected Impressive' is shown$")
	public void i_verify_the_message_You_have_selected_Impressive_is_shown() throws Throwable {
		Assert.assertEquals("You have selected Impressive", rbp.DisplayImpressive());
	   driver.close();
	}


}
