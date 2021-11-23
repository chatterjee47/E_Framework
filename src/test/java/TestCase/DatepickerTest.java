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
import PageObjectRepository.DatepickerPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DatepickerTest {
	
	static WebDriver driver;
	DatepickerPage dpp;
	UtilFile util;
	Alert alert;
	String today;
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
	
	@Given("^I go to Datepicker page$")
	public void i_go_to_Datepicker_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		dpp = new DatepickerPage(driver);
		dpp.datepickerlink();
		util = new UtilFile(driver);
		util.pause(3000);
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(3000);
	}

	@When("^I click on tomorrows date$")
	public void i_click_on_tomorrows_date() throws Throwable {
		dpp.calenderlink();
		util.pause(1000);
	}

	@Then("^Tommorows date should be selected$")
	public void tommorows_date_should_be_selected() throws Throwable {
        today = util.getCurrentDay();
        util.pause(1000);
        util.tomorrowdatepicker(today);
        util.pause(1000);
        System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow(); 
		driver.close();
	}



}
