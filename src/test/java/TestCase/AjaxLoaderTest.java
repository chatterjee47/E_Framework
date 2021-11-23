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
import PageObjectRepository.AjaxLoaderPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AjaxLoaderTest {
	static WebDriver driver;
	AjaxLoaderPage alp;
	UtilFile util;
	static String ExpectedMessage;
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
	
	@Given("^I go to Ajax-Loader page$")
	public void i_go_to_Ajax_Loader_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		alp = new AjaxLoaderPage(driver);
		alp.AjaxLoaderlink();
		util = new UtilFile(driver);
		util.pause(3000);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(1000);
	}

	@Given("^I click 'Click Me'$")
	public void i_click_Click_Me() throws Throwable {
		alp.ClickMebtn();
		util.pause(1000);
	}

	@Given("^I verify the following text in the modal 'Well Done For Waiting'$")
	public void i_verify_the_following_text_in_the_modal_Well_Done_For_Waiting() throws Throwable {
		util.pause(3000);
	    ExpectedMessage = alp.VerifyTextOne();
		System.out.println("Expected Message : " + ExpectedMessage);
	    Assert.assertEquals("Well Done For Waiting....!!!", ExpectedMessage); 
	    
	}

	@Given("^I verify the following text in the modal 'The waiting game can be a tricky one; this exercise will hopefully improve your understandings of the various types of waits\\.'$")
	public void i_verify_the_following_text_in_the_modal_The_waiting_game_can_be_a_tricky_one_this_exercise_will_hopefully_improve_your_understandings_of_the_various_types_of_waits() throws Throwable {
		util.pause(3000);
		ExpectedMessage = alp.VerifyTextTwo();
		System.out.println("Expected Message : " + ExpectedMessage);
	    Assert.assertEquals("The waiting game can be a tricky one; this exercise will hopefully improve your understandings of the various types of waits.", ExpectedMessage);
	    
	}

	@Given("^I click close$")
	public void i_click_close() throws Throwable {
	    
		alp.Closebtn();
	}

	@Then("^the modal shall close$")
	public void the_modal_shall_close() throws Throwable {
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow(); 
		driver.close();
	    
	}


}
