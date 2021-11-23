package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import BaseClass.BrowserSetup;
import PageObjectRepository.VerifyWebsitesPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VerifyWebsitesTest {
	
	static WebDriver driver;
	VerifyWebsitesPage vwp;
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
	
	
	@Given("^that I go to webdriveruniversity url$")
	public void that_I_go_to_webdriveruniversity_url() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	   
	}

	@Given("^I Go to the Login Portal$")
	public void i_Go_to_the_Login_Portal() throws Throwable {
		vwp = new VerifyWebsitesPage(driver);
		vwp.clickOnLoginPortal();
		util = new UtilFile(driver);
		util.pause(2000);
		util.WindowHandle();
		util.pause(500);
		util.ChildWindow();
		util.pause(500);
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		util.ParentWindow(); 
		util.pause(1000);
	}

	@Given("^I Go from the login portal to another website called simonskitchens url$")
	public void i_Go_from_the_login_portal_to_another_website_called_simonskitchens_url() throws Throwable {
		driver.navigate().to(prop.getProperty("UrlOne"));
		util.pause(1000);
	}

	@Given("^I click Kitchens$")
	public void i_click_Kitchens() throws Throwable {
		vwp.Kitchenstab();
		util.pause(1000);
	}

	@Given("^I select new england eight$")
	public void i_select_new_england_eight() throws Throwable {
		vwp.EnglandEight();
		util.pause(1000);
	}

	@Given("^I go back to the previous page and I click again Kitchens$")
	public void i_go_back_to_the_previous_page_and_I_click_again_Kitchens() throws Throwable {
	    driver.navigate().back();
	    vwp.Kitchenstab();
	    util.pause(1000);
	}

	@Given("^I select new england nine$")
	public void i_select_new_england_nine() throws Throwable {
		 vwp.EnglandNine();
		 util.pause(1000);
	}

	@Then("^New england nine kitchen page should be shown$")
	public void new_england_nine_kitchen_page_should_be_shown() throws Throwable {
		String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        util.pause(1000);
        Assert.assertEquals("https://www.simonskitchens.com/kitchens/new-england-9", currentURL);
	   driver.close();
	}


}
