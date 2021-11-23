package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.DropdownMenuCheckboxeRadioBtnsPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DropdownMenuCheckboxeRadioBtnsTest {
	static WebDriver driver;
	DropdownMenuCheckboxeRadioBtnsPage dmcd;
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
	
	
	@Given("^Land on Dropdown Menu\\(s\\), Checkboxe\\(s\\), Radio Btns page$")
	public void land_on_Dropdown_Menu_s_Checkboxe_s_Radio_Btns_page() throws Throwable {
	  
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		dmcd= new DropdownMenuCheckboxeRadioBtnsPage(driver);
		dmcd.DropdownMenuCheckboxeRadioBtnsClicks();
	    
	}

	@Given("^from the Dropdown Menu\\(s\\) I select C#$")
	public void from_the_Dropdown_Menu_s_I_select_C() throws Throwable {
		util = new UtilFile(driver);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(1000);
		dmcd.Selectdropdown(dmcd.dropdowmmenuone(),"C#");
		util.pause(1000);
	}

	@Given("^from the second Dropdown Menu I select Junit$")
	public void from_the_second_Dropdown_Menu_I_select_Junit() throws Throwable {
		dmcd.Selectdropdown(dmcd.dropdowmmenutwo(),"JUnit");
		util.pause(1000);
	}

	@Given("^from the third Dropdown Menu I select Html$")
	public void from_the_third_Dropdown_Menu_I_select_Html() throws Throwable {
		dmcd.Selectdropdown(dmcd.dropdowmmenuthree(),"HTML");
		util.pause(1000);
	}

	@Given("^again from the third Dropdown Menu I change Html to css$")
	public void again_from_the_third_Dropdown_Menu_I_change_Html_to_css() throws Throwable {
		dmcd.Selectdropdown(dmcd.dropdowmmenuthree(),"CSS");
		util.pause(1000);
	}

	@Given("^from the Checkboxe\\(s\\) I click on option three and option four$")
	public void from_the_Checkboxe_s_I_click_on_option_three_and_option_four() throws Throwable {
		dmcd.checkboxthree();
		util.pause(1000);
		dmcd.checkboxfour();
		util.pause(1000);
	}

	@Given("^from the Selected & Disabled I click Cabbage$")
	public void from_the_Selected_Disabled_I_click_Cabbage() throws Throwable {
		dmcd.SelectedDisabledCabbageradiobtn();
		util.pause(1000);
	}

	@Given("^from the Selected & Disabled dropdown menu I select Pear$")
	public void from_the_Selected_Disabled_dropdown_menu_I_select_Pear() throws Throwable {
		dmcd.Selectdropdown(dmcd.SelectedDisableddropdown(),"Pear");
		util.pause(1000);
	}

	@Given("^I click again the Selected & Disabled dropdown menu and I verify that Orange is disabled$")
	public void i_click_again_the_Selected_Disabled_dropdown_menu_and_I_verify_that_Orange_is_disabled() throws Throwable {
		dmcd.Orangeradiobtn().isEnabled();
		util.pause(1000);
	}

	@Then("^we should be able to verify that Orange is disabled$")
	public void we_should_be_able_to_verify_that_Orange_is_disabled() throws Throwable {
		util.pause(1000);
		if (dmcd.Orangeradiobtn().isEnabled()) {
	        // Print message to console
		System.out.println("Orange radio is enabled");
	} else {
		System.out.println("Orange radio not enabled");
	}
		
		System.out.println("Closing the Child window");
		driver.close();
		util.pause(1000);
		System.out.println("Closing the Parent window");
		util.ParentWindow(); 
		driver.close();
		
	}
	    
	
}
