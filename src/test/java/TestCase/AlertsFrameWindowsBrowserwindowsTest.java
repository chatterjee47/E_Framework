package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.AlertsFrameWindowsBrowserwindowsPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertsFrameWindowsBrowserwindowsTest {
	static WebDriver driver;
	AlertsFrameWindowsBrowserwindowsPage afwp;
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
	
	@Given("^I go to AlertsFrameWindows$")
	public void i_go_to_AlertsFrameWindows() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
		afwp = new AlertsFrameWindowsBrowserwindowsPage(driver);
		util = new UtilFile(driver);
		util.scrolltobottom();
		util.pause(2000);
		afwp.AlertsFrameWindowsarrowbtn();
		util.pause(2000);
	}

	@Given("^I click Browser windows$")
	public void i_click_Browser_windows() throws Throwable {
		afwp.BrowserWindows();
		util.pause(500);
	}

	@When("^I click new window$")
	public void i_click_new_window() throws Throwable {
		afwp.NewWindowbtn();
		util.pause(500);
	}

	@When("^I click away the new window$")
	public void i_click_away_the_new_window() throws Throwable {
		util.pause(500);
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		util.pause(500);
	}

	@Then("^the new window should close$")
	public void the_new_window_should_close() throws Throwable {
		util.pause(500);
	  driver.close();
	}

}