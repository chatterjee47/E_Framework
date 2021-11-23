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
import PageObjectRepository.AccordianTextAffectsPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AccordianTextAffectsTest {
	static WebDriver driver;
	AccordianTextAffectsPage atap;
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
	
	
	@Given("^I go to the ACCORDION & TEXT AFFECTS \\(APPEAR & DISAPPEAR\\) page$")
	public void i_go_to_the_ACCORDION_TEXT_AFFECTS_APPEAR_DISAPPEAR_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	    
	}

	@When("^I click on Manual Testing$")
	public void i_click_on_Manual_Testing() throws Throwable {
		atap = new AccordianTextAffectsPage(driver);
		atap.AccordianTextAffectslink();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		atap.manualtestingbtn();
		
	
	}

	@When("^I verify the following  Manual Testing text display$")
	public void i_verify_the_following_Manual_Testing_text_display() throws Throwable {
		util.pause(3000);
		String ExpectedMessage = atap.VerifyManualtestingText();
		System.out.println("Expected Message : " + ExpectedMessage);
	    Assert.assertEquals("Manual testing has for some time been the most popular way to test code. For this method, the tester plays an important role of end user and verifies that all the features of the application work correctly. Manual testing however is on the decline. Companies and developers have realised the efficiency, accuracy and cost savings that is possible by adopting the use of automation testing.", ExpectedMessage); 
	    
	}

	@When("^I click on Cucumber BDD$")
	public void i_click_on_Cucumber_BDD() throws Throwable {
		atap.cucumberBDD();
	    
	}

	@When("^I verify the Cucumber BDD text display$")
	public void i_verify_the_Cucumber_BDD_text_display() throws Throwable {
		util.pause(3000);
		String ExpectedMessage = atap.VerifycucumberBDDText();
		System.out.println("Expected Message : " + ExpectedMessage);
	    Assert.assertEquals("Cucumber (BDD) simplifies the requirement capturing process. Requirements can be captured, broken down and simplified effortlessly; making the captured requirements readable to anyone within the organisation and in turn providing the required details and backbone to develop accurate test cases also known as ‘Feature Files’.", ExpectedMessage); 
	    
	    System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow(); 
		driver.close();
	}

}
