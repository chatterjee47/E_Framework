package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.WidgetsDatePickerPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WidgetsDatePickerTest {
	static WebDriver driver;
	WidgetsDatePickerPage wdpp;
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
	
	
	@Given("^I go Widgets$")
	public void i_go_Widgets() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
		wdpp = new WidgetsDatePickerPage(driver);
		util = new UtilFile(driver);
		util.scrolltobottom();
		util.pause(2000);
		wdpp.WidgetTab();
		util.pause(2000);
	    
	}

	@Given("^I click on Date Picker$")
	public void i_click_on_Date_Picker() throws Throwable {
		wdpp.DatePickertab();
		util.pause(2000);
	}

	@When("^I click DateANDTime$")
	public void i_click_DateANDTime() throws Throwable {
		wdpp.dateAndTimePickerInput();
		util.pause(2000);
	}

	@When("^I click on month 'March'$")
	public void i_click_on_month_March() throws Throwable {
		wdpp.monthtab();
		util.pause(2000);
		util.verifydata(wdpp.monthselector(),"March");
		util.pause(2000);
		wdpp.dateselector();
		util.pause(2000);
	}

	@When("^I click on 'year'$")
	public void i_click_on_year() throws Throwable {
		wdpp.yeartab();
		util.pause(500);
		util.verifydata(wdpp.yearselector(),"2020");
		util.pause(500);
		wdpp.yeartab();
		util.pause(500);
		util.verifydata(wdpp.yearselector(),"2021");
		util.pause(500);
	}

	@Then("^the date and time should be selected$")
	public void the_date_and_time_should_be_selected() throws Throwable {
		util.pause(500);
		util.verifydata(wdpp.timeelector(),"22:45");
	    String dataTimedisplay = wdpp.verifydateAndTimePickerInput();
	    System.out.println("data Time display : " +dataTimedisplay);
	    driver.close();
	}


}
