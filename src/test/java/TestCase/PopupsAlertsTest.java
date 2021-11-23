package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import BaseClass.BrowserSetup;
import PageObjectRepository.PopupsAlertspage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PopupsAlertsTest {
	static WebDriver driver;
	PopupsAlertspage pap;
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
	
	@Given("^I go to Popups & Alerts page$")
	public void i_go_to_Popups_Alerts_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url")); 
		pap = new PopupsAlertspage(driver);
		pap.PopupsAlertslink();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(1000);
	}

	@When("^I click on click me on JavaScript Alert$")
	public void i_click_on_click_me_on_JavaScript_Alert() throws Throwable {
		pap.JavaScriptAlert();
		util.pause(1000);
	    
	}

	@When("^I click Ok on the javascript modal$")
	public void i_click_Ok_on_the_javascript_modal() throws Throwable {
		util.pause(1000);
		alert = driver.switchTo().alert();
		System.out.println("Alert message captured : " + alert.getText());
		Assert.assertEquals("I am an alert box!", alert.getText());
		util.pause(1000);
		alert.accept();
		System.out.println("Clicked on Ok button");
	}

	@When("^I click on click me on Modal Popup$")
	public void i_click_on_click_me_on_Modal_Popup() throws Throwable {
		util.pause(1000);
		pap.ModalPopup();
		util.pause(1000);
	}

	@When("^I verify the following text from the modal 'We can inject and use JavaScript code if all else fails! Remember always try to use WebDriver Library method\\(s\\) first such as WebElement\\.click\\(\\)\\. \\(The Selenium development team have spent allot of time developing WebDriver functions etc\\)\\.'$")
	public void i_verify_the_following_text_from_the_modal_We_can_inject_and_use_JavaScript_code_if_all_else_fails_Remember_always_try_to_use_WebDriver_Library_method_s_first_such_as_WebElement_click_The_Selenium_development_team_have_spent_allot_of_time_developing_WebDriver_functions_etc() throws Throwable {
		util.pause(1000);
		String ExpectedModalMessage = pap.ModalPopupMessage().getText();
	    System.out.println(ExpectedModalMessage);
	    Assert.assertEquals("We can inject and use JavaScript code if all else fails! Remember always try to use WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).", ExpectedModalMessage);
	    util.pause(1000);
	}

	@When("^User click on close$")
	public void user_click_on_close() throws Throwable {
		util.pause(1000);
		pap.ModalPopupClosebtn();
	}
	
	@Then("^modalwindow should be closed$")
	public void modalwindow_should_be_closed() throws Throwable {
		util.pause(1000);
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		util.ParentWindow(); 
		driver.close();
	}


}
