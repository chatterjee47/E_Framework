package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import BaseClass.BrowserSetup;
import PageObjectRepository.WebTablesPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebTablesTest {
	
	
	static WebDriver driver;
	WebTablesPage wtp;
	UtilFile util;
	Alert alert;
	static Properties prop;
	static FileInputStream fileInput;
	static File file = new File(System.getProperty("user.dir") + "\\config\\file.properties");
	
	String getFirstName;
	String getlastName;
	String getuserEmail;
	String getage;
	String getsalary;
	String getdepartment;
	
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
	
	
	
	@Given("^I go to Web Tables$")
	public void i_go_to_Web_Tables() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlTwo"));
		wtp = new WebTablesPage(driver);
		wtp.WebTablesbtn();
		util = new UtilFile(driver);
		util.pause(2000);  
	}

	@When("^I click on Add button$")
	public void i_click_on_Add_button() throws Throwable {
		wtp.addNewRecordButton();
		util.pause(2000);
	}

	@When("^I type in First name \"([^\"]*)\"$")
	public void i_type_in_First_name(String FirstName) throws Throwable {
	    
	   wtp.setFirstName(FirstName);
	   getFirstName = wtp.getFirstName();
	   System.out.println("Displaying FirstName : " + getFirstName);
	   util.pause(2000);
	}

	@When("^I type Last Name \"([^\"]*)\"$")
	public void i_type_Last_Name(String lastName) throws Throwable {
		wtp.setlastName(lastName);
		getlastName = wtp.getlastName();
		   System.out.println("Displaying lastName : " + getlastName);
		   util.pause(2000);

	}

	@When("^I type Email\"([^\"]*)\"$")
	public void i_type_Email(String userEmail) throws Throwable {
		wtp.setuserEmail(userEmail);
		getuserEmail = wtp.getuserEmail();
		   System.out.println("Displaying userEmail : " + getuserEmail);
		   util.pause(2000);
		
	}

	@When("^I type Age\"([^\"]*)\"$")
	public void i_type_Age(String age) throws Throwable {
		wtp.setage(age);
		getage = wtp.getage();
		   System.out.println("Displaying age : " + getage);
		   util.pause(2000);
		
	}

	@When("^I type Salary\"([^\"]*)\"$")
	public void i_type_Salary(String salary) throws Throwable {
		wtp.setsalary(salary);
		getsalary = wtp.getsalary();
		   System.out.println("Displaying salary : " + getsalary);
		   util.pause(2000);
		
	}

	@When("^I type Department\"([^\"]*)\"$")
	public void i_type_Department(String department) throws Throwable {
		wtp.setdepartment(department);
		getdepartment = wtp.getdepartment();
		   System.out.println("Displaying department : " + getdepartment);
		   util.pause(2000);
	
	}

	@When("^I click Submit$")
	public void i_click_Submit() throws Throwable {
		wtp.submitbtn();
		util.pause(2000);
	}

	@Then("^I can verify that typed in info has shown up in the page$")
	public void i_can_verify_that_typed_in_info_has_shown_up_in_the_page() throws Throwable {
		util.pause(2000);
		util.verifydatainfor(getFirstName);
		util.pause(2000);
		util.verifydatainfor(getlastName);
		util.pause(2000);
		util.verifydatainfor(getage);
		util.pause(2000);
		util.verifydatainfor(getuserEmail);
		util.pause(2000);
		util.verifydatainfor(getsalary);
		util.pause(2000);
		util.verifydatainfor(getdepartment);
		util.pause(2000);
		driver.close();
	}


}
