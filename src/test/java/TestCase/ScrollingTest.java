package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.Scrollingpage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScrollingTest {
	static WebDriver driver;
	Scrollingpage sp;
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
	
	@Given("^I go to Scrolling page$")
	public void i_go_to_Scrolling_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	}

	@When("^I scroll to the 'Dont forget to scroll to me' area$")
	public void i_scroll_to_the_Dont_forget_to_scroll_to_me_area() throws Throwable {
		sp = new Scrollingpage(driver);
		sp.scrollingaroundlink();
		util = new UtilFile(driver);
		util.pause(2000);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(500);
		util.scrolltobottom();
		util.pause(500);
	}

	@Then("^I verify that this character 'X:' is showing on the page$")
	public void i_verify_that_this_character_X_is_showing_on_the_page() throws Throwable {
		sp.ClickOnTextX();
		util.pause(500);
	   String verifyX = sp.VerifyTextX().getText();
	   System.out.println("Tezt display as :" + verifyX);
	   if(verifyX.contains("X:")){
		   System.out.println("Character X: is showing on the page");
	   }else{
		   System.out.println("Character X: is not showing on the page");
	   }
	   
	   System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		util.ParentWindow(); 
		driver.close();
	}

}
