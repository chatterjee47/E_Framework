package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.WebElementClickPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebElementClickTest {
	
	static WebDriver driver;
	WebElementClickPage bcp;
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
	
	
	@Given("^I am in  Button Clicks page$")
	public void i_am_in_Button_Clicks_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	   
	}

	@When("^I click WebElement click me$")
	public void i_click_WebElement_click_me() throws Throwable {
		bcp = new WebElementClickPage(driver);
		bcp.ButtonClicks();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		bcp.ClickMeOne();
	}

	@When("^press close$")
	public void press_close() throws Throwable {
		Thread.sleep(1000);
		bcp.CloseButton();
		Thread.sleep(1000);
	   
	}

	@Then("^the modal Congratulations should be closed$")
	public void the_modal_Congratulations_should_be_closed() throws Throwable {
		System.out.println("Closing the Child window");
		driver.close();
		Thread.sleep(1000);
		util.ParentWindow(); 
		driver.close();
	}
}
