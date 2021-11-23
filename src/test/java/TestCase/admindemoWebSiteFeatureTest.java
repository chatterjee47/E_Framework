package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.admindemoWebSiteFeaturePage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class admindemoWebSiteFeatureTest {
	static WebDriver driver;
	admindemoWebSiteFeaturePage adwsfp;
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
	
	
	   @Given("^I log into admin demo with \"([^\"]*)\" \"([^\"]*)\"$")
	  public void i_log_into_admin_demo_with(String UserName, String Password) throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlThree"));
		adwsfp = new admindemoWebSiteFeaturePage(driver);
		util = new UtilFile(driver);
		util.pause(2000);
		adwsfp.setEmailAddress(UserName);
		util.pause(2000);
		adwsfp.setPassword(Password);
		util.pause(2000);
		adwsfp.LoginButton();
		util.pause(2000);
	}
	   
	   @Given("^I open Products from Catalog in a new tab$")
	   public void i_open_Products_from_Catalog_in_a_new_tab() throws Throwable {
		   adwsfp.catalogbtn();
			util.pause(2000);
	     util.rightclickOpenWindow(adwsfp.products());
	      
	   }

	   @Given("^I close the previous tab$")
	   public void i_close_the_previous_tab() throws Throwable {
		   util.pause(2000);
			util.WindowHandle();
			util.pause(500);
			util.ChildWindow();
			util.pause(1000);
			System.out.println("Closing the Parent window");
			util.ParentWindow(); 
			driver.close();
			util.pause(500);
			util.ChildWindow();
			util.pause(1000);
	      
	   }

	   @Given("^I open Customer Roles from Customers in a new separate smaller window$")
	   public void i_open_Customer_Roles_from_Customers_in_a_new_separate_smaller_window() throws Throwable {
		   adwsfp.customers();
		   util.pause(2000);
		   util.rightclickOpenWindows(adwsfp.customerroles());
		 
	   }

	   @Given("^I close the previous Products tab$")
	   public void i_close_the_previous_Products_tab() throws Throwable {
		   util.pause(2000);
			util.WindowHandle();
			util.pause(500);
			util.ChildWindow();
			util.pause(1000);
			System.out.println("Closing the Parent window");
			util.ParentWindow(); 
			driver.close();
			util.pause(500);
			util.ChildWindow();
			util.pause(1000);
	      
	   }

	   @Given("^in the smaller window I click on Online customers$")
	   public void in_the_smaller_window_I_click_on_Online_customers() throws Throwable {
	     
		   adwsfp.onlinecustomers();
			util.pause(1000);
	   }

	   @Given("^I make the smaller window bigger by maximizing it$")
	   public void i_make_the_smaller_window_bigger_by_maximizing_it() throws Throwable {
		   util.pause(1000);
	     driver.quit();
	      
	   }


}
