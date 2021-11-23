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

public class ActionsTest_ScenarioTwo {
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
	
	@Given("^I navigate go to Actions Page$")
	public void i_navigate_go_to_Actions_Page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	   
	}

	@Given("^I double click on the 'Double Click Me!' area$")
	public void i_double_click_on_the_Double_Click_Me_area() throws Throwable {
		ap = new ActionsPage_Scenarios(driver);
		ap.Actionslink();
		util = new UtilFile(driver);
		util.pause(2000);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(500);
		ap.doubleclick();
	   
	}

	@Given("^I hover over the 'Hover Over Me First!'$")
	public void i_hover_over_the_Hover_Over_Me_First() throws Throwable {
		util.pause(2000);
		System.out.println("Mouse Over and Clicking");
	}

	@Given("^I click 'Link one'$")
	public void i_click_Link_one() throws Throwable {
		util.pause(2000);
		util.MouseOver(ap.HoverOverMeFirst(), ap.linkone());
		util.pause(2000);
	}

	@Given("^I verify the string 'Well done you clicked on the link!'$")
	public void i_verify_the_string_Well_done_you_clicked_on_the_link() throws Throwable {
		alert = driver.switchTo().alert();
		System.out.println("Alert message captured : " + alert.getText());
		Assert.assertEquals("Well done you clicked on the link!", alert.getText());
	}

	@Given("^I click Ok$")
	public void i_click_Ok() throws Throwable {
		alert.accept();
		System.out.println("Clicked on Ok button");
	}

	@Then("^The javascript modal should get close$")
	public void the_javascript_modal_should_get_close() throws Throwable {
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		util.ParentWindow(); 
		driver.close();
	}

}