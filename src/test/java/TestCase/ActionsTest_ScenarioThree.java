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
import PageObjectRepository.ActionsPage_Scenarios;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class ActionsTest_ScenarioThree {
	static WebDriver driver;
	ActionsPage_Scenarios ap;
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
	
	@Given("^I landed on Actions Page$")
	public void i_landed_on_Actions_Page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	   
	}

	@Given("^I click on 'Don't Release me'$")
	public void i_click_on_Don_t_Release_me() throws Throwable {
		ap = new ActionsPage_Scenarios(driver);
		ap.Actionslink();
		util = new UtilFile(driver);
		util.pause(2000);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(500);
		util.ClickAndHold(ap.ClickHold());
	   
	}

	
	@Then("^I verify the string 'Well done! keep holding that click now\\.\\.\\.\\.\\.'$")
	public void i_verify_the_string_Well_done_keep_holding_that_click_now() throws Throwable {
	    String ExpectedMessage = ap.ClickHold().getText();
	    System.out.println("Message display as : " + ExpectedMessage);//Well done! keep holding that click now.....
	    Assert.assertEquals(ExpectedMessage, "Well done! keep holding that click now.....");
	}

	@Then("^I hover over the 'Hover Over Me Third!'$")
	public void i_hover_over_the_Hover_Over_Me_Third() throws Throwable {
		util.pause(2000);
		System.out.println("Mouse Over and Clicking");
	}

	@Then("^I click the second 'Link one'$")
	public void i_click_the_second_Link_one() throws Throwable {
		util.pause(2000);
		util.MouseOver(ap.HoverOverMeThird(), ap.HoverOverMeThirdlink());
		util.pause(2000);
	}

	
	@Then("^the Javascript modal should come up$")
	public void the_Javascript_modal_should_come_up() throws Throwable {
		alert = driver.switchTo().alert();
		System.out.println("Alert message captured : " + alert.getText());
		Assert.assertEquals("Well done you clicked on the link!", alert.getText());
		alert.accept();
		System.out.println("Clicked on Ok button");
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		util.ParentWindow(); 
		driver.close();
	}


}