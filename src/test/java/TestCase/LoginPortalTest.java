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
import PageObjectRepository.LoginPortalPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPortalTest extends BrowserSetup {
	static WebDriver driver;
	LoginPortalPage login;
	UtilFile util;
	Alert alert;
	static Properties prop;
	static FileInputStream fileInput;
	static File file = new File(System.getProperty("user.dir") + "\\config\\file.properties");

	@Before
	public void Configuration() {
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

	@Given("^I go to webdriveruniversity website$")
	public void i_go_to_webdriveruniversity_website() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	}

	@When("^I clicked on Login Portal link$")
	public void i_clicked_on_Login_Portal_link() throws Throwable {
		login = new LoginPortalPage(driver);
		login.clickOnLoginPortal();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}

	@When("^I type Username \"([^\"]*)\"$")
	public void i_type_Username(String username) throws Throwable {
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		login.setUsername(username);
	}

	@When("^I type password \"([^\"]*)\"$")
	public void i_type_password(String password) throws Throwable {
		login.setPassword(password);
	}

	@When("^I click login button$")
	public void i_click_login_button() throws Throwable {
		login.ClickOnLoginButton();
	}

	@Then("^I can be able to log in successfully$")
	public void i_can_be_able_to_log_in_successfully() throws Throwable {
		alert = driver.switchTo().alert();
		System.out.println("Alert message captured : " + alert.getText());
		alert.accept();
		System.out.println("Login Successfully");
	}

	@Then("^User close the Browser$")
	public void user_close_the_Browser() throws Throwable {
		System.out.println("Closing the Child window");
		driver.close();
		util.ParentWindow();
		driver.close();
	}

}
