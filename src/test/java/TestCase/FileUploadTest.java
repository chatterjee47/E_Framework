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
import PageObjectRepository.FileUploadPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FileUploadTest {
	static WebDriver driver;
	FileUploadPage fup;
	UtilFile util;
	Alert alert;
	static Properties prop;
	static FileInputStream fileInput;
	static File file = new File(System.getProperty("user.dir") + "\\config\\file.properties");
	static String fileupload = System.getProperty("user.dir") + "\\data\\PNGFile.PNG";
	
	
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
	
	@Given("^I go to File Upload page$")
	public void i_go_to_File_Upload_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		fup = new FileUploadPage(driver);
		fup.FileUploadlink();
		util = new UtilFile(driver);
		util.pause(1000);
	}

	@Given("^I click Choose file$")
	public void i_click_Choose_file() throws Throwable {
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		util.pause(1000);
		util.WindowHandle();
		util.ChildWindow();
		util.pause(1000);
	}

	@Given("^I choose a file from the pc and upload it$")
	public void i_choose_a_file_from_the_pc_and_upload_it() throws Throwable {
		util.pause(1000);
		fup.ChooseFile(fileupload);
		System.out.println("File is Uploaded Successfully");
		util.pause(1000);
	}

	@Given("^I click on submit button$")
	public void i_click_on_submit_button() throws Throwable {
		fup.submitbutton();
		util.pause(1000);
	}

	@Then("^a modal confirmation shows 'Your file has now been uploaded!'$")
	public void a_modal_confirmation_shows_Your_file_has_now_been_uploaded() throws Throwable {
		util.pause(1000);
		alert = driver.switchTo().alert();
		System.out.println("Alert message captured : " + alert.getText());
		Assert.assertEquals("Your file has now been uploaded!", alert.getText());
		util.pause(1000);
		alert.accept();
		System.out.println("Clicked on Ok button");
		  System.out.println("Closing the Child window");
			driver.close();
			util.pause(1000);
			System.out.println("Closing the Parent window");
			util.ParentWindow(); 
			driver.close();
	}


}
