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
import PageObjectRepository.IFramepage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class IFramepageTest {
	
	static WebDriver driver;
	IFramepage Ip;
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
	
	@Given("^I go to IFrame page$")
	public void i_go_to_IFrame_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		Ip = new IFramepage(driver);
		Ip.iframelink();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
			    }

	@Given("^I click Find out more$")
	public void i_click_Find_out_more() throws Throwable {
		util.pause(2000);
		util.switchToIframe(Ip.frame());
			 util.pause(2000);
				Ip.findoutmore();
				util.pause(2000);
				util.scrollToView(Ip.Modal());
				util.pause(2000);	
	}

	@Given("^I click Close on the modal$")
	public void i_click_Close_on_the_modal() throws Throwable {
	    Ip.Closefindoutmore();
	    util.pause(2000);
	}

	@Given("^I click Contact us$")
	public void i_click_Contact_us() throws Throwable {
		Ip.ContactUs();
		util.pause(2000);
	}

	@Given("^I fill in the contact us page with all the information except with an incorrect email$")
	public void i_fill_in_the_contact_us_page_with_all_the_information_except_with_an_incorrect_email() throws Throwable {
		util.pause(2000);
		Ip.FirstName("amit");
		Ip.LastName("chatterjee");
		Ip.EmailAddress("abcdamit.com");
		Ip.Comments("happy");
		util.pause(2000);
	    
	}

	@Given("^I click submit$")
	public void i_click_submit() throws Throwable {
	    Ip.submitbtn();
	    util.pause(2000);
	}

	@Given("^I verify the error message 'Error: Invalid email address'$")
	public void i_verify_the_error_message_Error_Invalid_email_address() throws Throwable {
		util.pause(2000);
		Ip.verifyError();
	}

	@Given("^on the browser I click the previous button$")
	public void on_the_browser_I_click_the_previous_button() throws Throwable {
		util.pause(2000);
	    driver.navigate().back();
	}

	@Given("^on the browser I click the previous button again$")
	public void on_the_browser_I_click_the_previous_button_again() throws Throwable {
		util.pause(2000);
		driver.navigate().back();
		
	}

	@Then("^I should go back to the IFrame page$")
	public void i_should_go_back_to_the_IFrame_page() throws Throwable {
		util.pause(2000);
		Assert.assertEquals("WebdriverUniversity.com (IFrame)", Ip.IframeTitle().getText());
		util.pause(2000);
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow(); 
		driver.close();
	}


}
