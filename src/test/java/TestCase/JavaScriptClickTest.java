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
import PageObjectRepository.JavaScriptClickPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JavaScriptClickTest {
	
	static WebDriver driver;
	JavaScriptClickPage jscp;
	UtilFile util;
	Alert alert;
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
	
	@Given("^User is in  Button Clicks page$")
	public void user_is_in_Button_Clicks_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	    
	}

	@When("^I click JavaScript Click <click me>$")
	public void i_click_JavaScript_Click_click_me() throws Throwable {
		jscp = new JavaScriptClickPage(driver);
		jscp.ButtonClicks();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		jscp.ClickMeOne();
	}

	@When("^I verify that the string is present with some message$")
	public void i_verify_that_the_string_is_present_with_some_message() throws Throwable {
		util.pause(3000);
		String ExpectedMessage = jscp.DisplayMessage();
		System.out.println("Expected Message : " + ExpectedMessage);
	    Assert.assertEquals("It’s that Easy!! Well I think it is.....", ExpectedMessage);  
	}

	@When("^close the pop window$")
	public void close_the_pop_window() throws Throwable {
		util.pause(1000);
		jscp.CloseButton();
		util.pause(1000);
	    
	}

	@Then("^the modal <It’s that Easy!! Well I think it is>should be closed$")
	public void the_modal_It_s_that_Easy_Well_I_think_it_is_should_be_closed() throws Throwable {
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		util.ParentWindow(); 
		driver.close();
	    
	}

}
