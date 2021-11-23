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
import PageObjectRepository.CheckboxPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CheckboxTest {
	
	static WebDriver driver;
	CheckboxPage cbp;
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
	
	@Given("^I go to 'https://demoqa\\.com/elements'$")
	public void i_go_to_https_demoqa_com_elements() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
	}

	@Given("^I click check box$")
	public void i_click_check_box() throws Throwable {
		cbp = new CheckboxPage(driver);
		cbp.Checkboxbtn();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util = new UtilFile(driver);
		util.pause(3000);
	    
	}

	@When("^I click the home accordion button to expand it$")
	public void i_click_the_home_accordion_button_to_expand_it() throws Throwable {
		cbp.Togglebtn();
		util.pause(3000);
	}

	@When("^I click the downloads accordion button to expand it$")
	public void i_click_the_downloads_accordion_button_to_expand_it() throws Throwable {
		cbp.ToggleDownload();
		util.pause(3000);
	    
	}

	@When("^I tick Word File\\.doc$")
	public void i_tick_Word_File_doc() throws Throwable {
		cbp.WordFile();
		util.pause(3000);
	    
	}

	@Then("^the section should be ticked$")
	public void the_section_should_be_ticked() throws Throwable {
	    String messagedisplay = cbp.displayWordFile().getText();
	    Assert.assertEquals("wordFile", messagedisplay);
	    driver.close();
	}


}
