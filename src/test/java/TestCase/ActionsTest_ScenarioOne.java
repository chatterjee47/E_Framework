package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.ActionsPage_Scenarios;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ActionsTest_ScenarioOne {
	static WebDriver driver;
	ActionsPage_Scenarios ap;
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
	
	@Given("^I go to Actions Page$")
	public void i_go_to_Actions_Page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
	   
	}

	@Given("^I verify that the webpage is showing the text 'DROP HERE!'$")
	public void i_verify_that_the_webpage_is_showing_the_text_DROP_HERE() throws Throwable {
		ap = new ActionsPage_Scenarios(driver);
		ap.Actionslink();
		util = new UtilFile(driver);
		util.pause(2000);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(500);
	   
	}

	@Given("^If I put the square 'Drag me to my' target to the 'DROP HERE!' area$")
	public void if_I_put_the_square_Drag_me_to_my_target_to_the_DROP_HERE_area() throws Throwable {
		util.pause(2000);
		util.ActionKeyword(ap.locatorfrom(),ap.locatorone());
		util.pause(2000);
	}

	@Then("^I verify that the drop here area is changed from 'DROP HERE!' to 'Dropped!'$")
	public void i_verify_that_the_drop_here_area_is_changed_from_DROP_HERE_to_Dropped() throws Throwable {
		//verify text changed in to 'Drop here' box 
		util.pause(2000);
				String textTo = ap.locatorone().getText();
				if(textTo.equals("Dropped!")) {
					System.out.println("DRAG ME TO MY TARGET! is dropped to Drop here");
				}else {
					System.out.println("DRAG ME TO MY TARGET! is not dropped to Drop here");
				}
				
				System.out.println("Closing the Child window");
				driver.close();
				util.pause(1000);
				System.out.println("Closing the Parent window");
				util.ParentWindow(); 
				driver.close();
	   
	}


}
