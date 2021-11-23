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
import PageObjectRepository.RegistrationPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RegistrationTest {
	
	static WebDriver driver;
	RegistrationPage reg;
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
	
	@Given("^that I am in the login page 'https://demoqa\\.com/login'$")
	public void i_go_to_https_demoqa_com_elements() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlFour"));
	}

	@When("^I click the button 'New User'$")
	public void i_click_check_box() throws Throwable {
		reg = new RegistrationPage(driver);
		reg.NewUserbtn();
		util = new UtilFile(driver);
		util.pause(3000);
	    
	}

	@Then("^I am on the Registration Page$")
	public void i_click_the_home_accordion_button_to_expand_it() throws Throwable {
		String validateRegistertoBookStore = reg.validateRegistertoBookStore();
		Assert.assertEquals("Register to Book Store", validateRegistertoBookStore);
		util.pause(3000);
	}

	@Then("^I type in First Name \"([^\"]*)\"$")
	public void i_type_in_First_Name(String FirstName) throws Throwable {
	   reg.firstname(FirstName);
	   util.pause(3000);
	}

	@Then("^I type in Last Name \"([^\"]*)\"$")
	public void i_type_in_Last_Name(String lastname) throws Throwable {
		 reg.lastname(lastname);
		 util.pause(3000);
	}

	@Then("^I type in UserName \"([^\"]*)\"$")
	public void i_type_in_UserName(String userName) throws Throwable {
		 reg.userName(userName);
		 util.pause(3000);
	}

	@Then("^I type in Password \"([^\"]*)\"$")
	public void i_type_in_Password(String password) throws Throwable {
		 reg.password(password);
		 util.pause(3000);
		 util.scrollDown();
	}

	@Then("^I click Register$")
	public void i_click_Register() throws Throwable {
	    reg.registerbtn();
	    util.pause(3000);
	    driver.close();
	}




}
