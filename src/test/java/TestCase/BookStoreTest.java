package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.BookStorePage;
import PageObjectRepository.LoginPage;
import Utility.UtilFile;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookStoreTest {
	
	static WebDriver driver;
	BookStorePage bsp;
	LoginPage reg;
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
	
	
	
	@Given("^that I am logged in on the profile page$")
	public void that_I_am_logged_in_on_the_profile_page() throws Throwable {
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("UrlFour"));
		
	}
	
	@When("^I entered UserName \"([^\"]*)\"$")
	public void i_entered_UserName(String UserName) throws Throwable {
		bsp = new BookStorePage(driver);
		util = new UtilFile(driver);
		util.pause(3000);
		reg = new LoginPage(driver);
		reg.setUsername(UserName);
		util = new UtilFile(driver);
		util.pause(3000);
	}

	@Then("^I entered Password \"([^\"]*)\"$")
	public void i_entered_Password(String Password) throws Throwable {
		reg.setPassword(Password);
		   util.pause(3000);
	}

	@Then("^I clicked on Login button$")
	public void i_clicked_on_Login_button() throws Throwable {
		reg.Loginbtn();
		util.pause(3000);
	}



	@Given("^I click and expand Book Store Application$")
	public void i_click_and_expand_Book_Store_Application() throws Throwable {
		util = new UtilFile(driver);
		util.pause(3000);
		util.scrollDown();
		util.pause(3000);
	    
	}

	@Given("^I click Book Store$")
	public void i_click_Book_Store() throws Throwable {
		bsp = new BookStorePage(driver);
		bsp.BookStoreLink();
		util.pause(3000);
	    
	}

	@Given("^I search in the search bar \"([^\"]*)\"$")
	public void i_search_in_the_search_bar(String GitPocketguide) throws Throwable {
		util.pause(3000);
	    bsp.searchBox(GitPocketguide);
	}

	@Given("^I click on the book title 'Git Pocket Guide'$")
	public void i_click_on_the_book_title_Git_Pocket_Guide() throws Throwable {
		util.pause(3000);
		bsp.Title_BookStore();
	    
	}

	@Given("^I click on the button 'Add To Your Collection'$")
	public void i_click_on_the_button_Add_To_Your_Collection() throws Throwable {
		util.pause(3000);
		util.scrollDown();
		util.pause(3000);
		bsp.AddToYourCollection();
	    
	}

	@Given("^I click Ok when the website shows the message that the book is added to collection$")
	public void i_click_Ok_when_the_website_shows_the_message_that_the_book_is_added_to_collection() throws Throwable {
		util.pause(3000);
		System.out.println(driver.switchTo().alert().getText());
		util.pause(3000);
        driver.switchTo().alert().accept();
        util.pause(3000);
	    
	}

	@Given("^I click on Profile$")
	public void i_click_on_Profile() throws Throwable {
		util.pause(3000);
		util.scrollDown();
		util.pause(3000);
	    bsp.ProfileLink();
	    
	}

	@Then("^I verify that the book title 'Git Pocket Guide' is there$")
	public void i_verify_that_the_book_title_Git_Pocket_Guide_is_there() throws Throwable {
	    bsp.Verify_BookStore();
	    driver.close();
	    
	}



}
