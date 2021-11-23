package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.BrowserSetup;
import PageObjectRepository.AlertsFrameWindowsBrowserwindowsPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertsFrameWindowsNestedFramesTest {
	static WebDriver driver;
	AlertsFrameWindowsBrowserwindowsPage afwp;
	UtilFile util;
	static List<WebElement> listdata;
	static int countIframesInPage;
	Alert alert;
	static WebElement frameElement;
	static String frameText;
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
	
	@Given("^I go to Alerts, Frame & Windows$")
	public void i_go_to_Alerts_Frame_Windows() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
		afwp = new AlertsFrameWindowsBrowserwindowsPage(driver);
		util = new UtilFile(driver);
		util.scrolltobottom();
		util.pause(2000);
		afwp.AlertsFrameWindowsarrowbtn();
		util.pause(2000);
	}

	@When("^I click Nested Frames$")
	public void i_click_Nested_Frames() throws Throwable {
		afwp.NestedFrames();
		util.pause(2000);
	}

	@Then("^I can verify the Child Iframe message is present on the page$")
	public void i_can_verify_the_Child_Iframe_message_is_present_on_the_page() throws Throwable {
		util.pause(2000);
	       listdata = afwp.iframe();
            countIframesInPage = listdata.size();
            System.out.println("Number of Frames on a Page:" + countIframesInPage);
            for(int j=0;j<countIframesInPage;j++){
           	driver.switchTo().frame(j);
            WebElement frameElement= afwp.iFrameslocator();
            frameText=frameElement.getText();
            System.out.println("Parent Iframe message present on the page is : "+frameText);
            util.pause(2000);
            }
	}

	@Then("^I can verify the Parent frame message is present on the page$")
	public void i_can_verify_the_Parent_frame_message_is_present_on_the_page() throws Throwable {
		util.pause(2000);
	      listdata = afwp.iframe();
         countIframesInPage = listdata.size();
         System.out.println("Number of Frames on a Page:" + countIframesInPage);
         for(int j=0;j<countIframesInPage;j++){
        	 driver.switchTo().frame(j);
         frameElement= afwp.iFrameslocator();
         frameText=frameElement.getText();
         System.out.println("Child Iframe message present on the page is : "+frameText);
         util.pause(2000);
         }
        util.pause(2000);
        driver.close();
	}
}