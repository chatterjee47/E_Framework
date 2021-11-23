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
import PageObjectRepository.ActionMoveClickPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActionMoveClickTest {
	static WebDriver driver;
	ActionMoveClickPage amcp;
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
	
	@Given("^User Clicks on Button page$")
	public void user_Clicks_on_Button_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	}
	
	@When("^I click Action Move & Click <click me>$")
	public void i_click_Action_Move_Click_click_me() throws Throwable {
		amcp = new ActionMoveClickPage(driver);
		amcp.ButtonClicks();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		amcp.ClickMeOne();
		
		util.pause(3000);
		String ExpectedMessage = amcp.DisplayMessage();
		System.out.println("Expected Message : " + ExpectedMessage);
	    Assert.assertEquals("Action Move & Click", ExpectedMessage); 
	    
	}
	
	@When("^Click on close button$")
	public void click_on_close_button() throws Throwable {
		util.pause(1000);
		amcp.CloseButton();
		util.pause(1000);
	    
	}


	@Then("^the modal should be closed$")
	public void the_modal_should_be_closed() throws Throwable {
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow(); 
		driver.close();
	}
	
	}
