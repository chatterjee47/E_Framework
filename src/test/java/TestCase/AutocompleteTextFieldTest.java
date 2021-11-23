package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BaseClass.BrowserSetup;
import PageObjectRepository.AutocompleteTextFieldPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AutocompleteTextFieldTest {
	static WebDriver driver;
	AutocompleteTextFieldPage atfp;
	UtilFile util;
	Alert alert;
	List<WebElement> Autocompletelists;
	String actualdata;
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

	@Given("^I go to Autocomplete TextField page$")
	public void i_go_to_Autocomplete_TextField_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		atfp = new AutocompleteTextFieldPage(driver);
		atfp.AutocompleteTextFieldlink();
		util = new UtilFile(driver);
		util.pause(1000);
		util.WindowHandle();
		util.pause(1000);
		util.ChildWindow();
		util.pause(500);
	}

	@Given("^I type in P on the search area$")
	public void i_type_in_P_on_the_search_area() throws Throwable {
		atfp.FoodItem("P");
		util.pause(500);
	}

	@Then("^I verify the the following came up as selection: Pizza Pepperoni Pancakes$")
	public void i_verify_the_the_following_came_up_as_selection_Pizza_Pepperoni_Pancakes() throws Throwable {
		util.pause(100);
		util.verifyautoselect();
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow();
		driver.close();
	}

}
