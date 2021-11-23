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
import PageObjectRepository.ButtonsKeywordPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ButtonsKeywordTest {
	static WebDriver driver;
	ButtonsKeywordPage bkp;
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
	
	
	@Given("^I go to Buttons$")
	public void i_go_to_Buttons() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
	}

	@When("^I double click on Double Click Me button$")
	public void i_double_click_on_Double_Click_Me_button() throws Throwable {
		bkp = new ButtonsKeywordPage(driver);
		bkp.getButtonsTab();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.pause(1000);
		util.doubleclick(bkp.getdoubleClickBtn());
	}

	@When("^I right click on right Click Me button$")
	public void i_right_click_on_right_Click_Me_button() throws Throwable {
		util.rightclick(bkp.getrightClickBtn());
		String rightClickMessage= bkp.rightClickMessage().getText();
		System.out.println("right Click Message display as :" + rightClickMessage);
		Assert.assertEquals("You have done a right click", rightClickMessage);
	}

	@Then("^I can verify that the following info has shown up in the page  'You have done a double click'$")
	public void i_can_verify_that_the_following_info_has_shown_up_in_the_page_You_have_done_a_double_click() throws Throwable {
		String doubleClickMessage= bkp.doubleClickMessage().getText();
		System.out.println("double Click Message display as :" + doubleClickMessage);
		Assert.assertEquals("You have done a double click", doubleClickMessage);
		driver.close();
	}
}
