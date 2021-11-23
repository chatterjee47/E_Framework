package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import BaseClass.BrowserSetup;
import PageObjectRepository.WidgetsAccordianPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WidgetsAccordianTest {
	static WebDriver driver;
	WidgetsAccordianPage wap;
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
	
	@Given("^I go to Widgets$")
	public void i_go_to_Widgets() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
		wap = new WidgetsAccordianPage(driver);
		util = new UtilFile(driver);
		util.scrolltobottom();
		 util.pause(2000);
		wap.WidgetsAccordianTab();
		 util.pause(2000);
	}

	@Given("^I click on Accordian$")
	public void i_click_on_Accordian() throws Throwable {
		 util.pause(2000);
	    wap.AccordianTab();
	}

	@When("^I click 'What is Lorem Ipsum\\?'$")
	public void i_click_What_is_Lorem_Ipsum() throws Throwable {
		 util.pause(2000);
		wap.WhatisLoremIpsum();
	  
	}

	@When("^I click 'Where does it come from\\?'$")
	public void i_click_Where_does_it_come_from() throws Throwable {
		 util.pause(2000);
		wap.Wheredoesitcomefrom();
		 util.pause(2000);
			wap.Wheredoesitcomefrom();
	  
	}

	@When("^I click 'Why do we use it\\?'$")
	public void i_click_Why_do_we_use_it() throws Throwable {
		 util.pause(2000);
		wap.Whydoweuseit();
	  
	}

	@Then("^the accordian 'Why do we use it\\?' should expand$")
	public void the_accordian_Why_do_we_use_it_should_expand() throws Throwable {
		 util.pause(2000);
		String WhydoweuseitMessage = wap.WhydoweuseitMessage();
		System.out.println("Message display as : " + WhydoweuseitMessage);
		if(WhydoweuseitMessage.contains("It is a long established fact that a reader will b")){
			System.out.println("It is expanded");
		}else{
			System.out.println("It is not expanded");
		}
		driver.close();
	}


}
