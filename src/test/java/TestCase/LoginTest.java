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
import PageObjectRepository.LoginPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginTest {
	
	static WebDriver driver;
	LoginPage reg;
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

	
	@Given("^I am in the login page 'https://demoqa\\.com/login'$")
	public void i_am_in_the_login_page_https_demoqa_com_login() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlFour"));
	}
	
	@When("^I enter UserName \"([^\"]*)\"$")
	public void i_enter_UserName(String UserName) throws Throwable {
		reg = new LoginPage(driver);
		reg.setUsername(UserName);
		util = new UtilFile(driver);
		util.pause(3000);
	}

	@Then("^I enter Password \"([^\"]*)\"$")
	public void i_enter_Password(String Password) throws Throwable {
	   reg.setPassword(Password);
	   util.pause(3000);
	}

	@Then("^I click on Login button$")
	public void i_click_on_Login_button() throws Throwable {
	   reg.Loginbtn();
		util.pause(3000);
	}

	@Then("^I should be on the profile page$")
	public void i_should_be_on_the_profile_page() throws Throwable {
		String validateProfile = reg.validateProfile();
		Assert.assertEquals("Profile", validateProfile);
		util.pause(3000);
	}

	@Then("^I verify the title on the profile page \"([^\"]*)\"$")
	public void i_verify_the_title_on_the_profile_page(String Title) throws Throwable {
		String validateTitlePage = driver.getTitle();
		Assert.assertEquals(Title, validateTitlePage);
		util.pause(3000);
		driver.close();
	}




}
