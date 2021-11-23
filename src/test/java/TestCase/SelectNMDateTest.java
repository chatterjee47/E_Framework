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
import PageObjectRepository.SelectNMDatePage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectNMDateTest {
	static WebDriver driver;
	SelectNMDatePage snmdp;
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
	
	@Given("^Launch Datepicker page$")
	public void launch_Datepicker_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		snmdp = new SelectNMDatePage(driver);
		snmdp.DATEPICKERlink();
		util = new UtilFile(driver);
		util.pause(2000);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(1000);
	}

	@When("^I click on the date second november twenty twenty$")
	public void i_click_on_the_date_second_november_twenty_twenty() throws Throwable {
		snmdp.calendertab();
		util.pause(1000);
		snmdp.datepickerswitch_One();
		util.pause(500);
		snmdp.datepickerswitch_Two();
		util.pause(500);
		util.verifydata(snmdp.yearselection(),"2020");
		util.pause(500);
		util.verifydata(snmdp.monthselection(),"Nov");
		util.pause(500);
		util.verifydata(snmdp.dateselection(),"2");
		util.pause(500);
		
	}

	@When("^I click on the date fifth march twenty twentyone$")
	public void i_click_on_the_date_fifth_march_twenty_twentyone() throws Throwable {
		snmdp.calendertab();
		util.pause(1000);
		snmdp.datepickerswitch_One();
		util.pause(500);
		snmdp.datepickerswitch_Two();
		util.pause(500);
		util.verifydata(snmdp.yearselection(),"2021");
		util.pause(500);
		util.verifydata(snmdp.monthselection(),"Mar");
		util.pause(500);
		util.verifydata(snmdp.dateselection(),"5");
		util.pause(500);
	}

	@Then("^the date fifth march twenty twentyone should be selected$")
	public void the_date_fifth_march_twenty_twentyone_should_be_selected() throws Throwable {
		String datedisplay = snmdp.datedisplay();
		System.out.println("date display as : " + datedisplay);
		Assert.assertEquals("03-05-2021", datedisplay);
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow(); 
		driver.close();

	}
}
