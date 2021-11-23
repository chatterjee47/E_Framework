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
import PageObjectRepository.PageObjectModelPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PageObjectModelTest {
	
	static WebDriver driver;
	PageObjectModelPage pomp;
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
	
	@Given("^I go to the page called Page Object Model$")
	public void i_go_to_the_page_called_Page_Object_Model() throws Throwable {
	    
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	}

	@Given("^I click Our products$")
	public void i_click_Our_products() throws Throwable {
		pomp = new PageObjectModelPage(driver);
		pomp.PAGEOBJECTMODELClicks();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(3000);
		pomp.OurProducts();
		util.pause(3000);
	}

	@Given("^I click New Laptops$")
	public void i_click_New_Laptops() throws Throwable {
		pomp.NewLaptops();
		util.pause(3000);
	}

	@Given("^I verify from the modal the number <NEWCUSTOMER>$")
	public void i_verify_from_the_modal_the_number_NEWCUSTOMER() throws Throwable {
		util.pause(3000);
		String ExpectedMessage = pomp.VerifyText();
		System.out.println("Expected Message : " + ExpectedMessage);
	    Assert.assertEquals("NEWCUSTOMER773322", ExpectedMessage); 
	    util.pause(3000);
	}

	@Given("^I click proceed$")
	public void i_click_proceed() throws Throwable {
		pomp.Proceedbtn();
		util.pause(3000);
	}

	@Given("^I click desktop systems$")
	public void i_click_desktop_systems() throws Throwable {
		pomp.DesktopSystems();
		util.pause(3000);
	}

	@Given("^I click Cancel$")
	public void i_click_Cancel() throws Throwable {
		pomp.Closebtn();
		util.pause(3000);
	}

	@Then("^the modal should be cancelled$")
	public void the_modal_should_be_cancelled() throws Throwable {
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		util.ParentWindow(); 
		driver.close();
	    
	}
}

