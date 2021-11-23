package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='newUser']")
	private WebElement NewUserbtn;
	
	public void NewUserbtn() {
		NewUserbtn.click();
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Register to Book Store')]")
	private WebElement validateRegistertoBookStore;
	
	public String validateRegistertoBookStore() {
		return validateRegistertoBookStore.getText();
	}
	
	
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstname;
	
	public void firstname(String strfirstname) {
		firstname.sendKeys(strfirstname);
	}
	
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastname;
	
	public void lastname(String strlastname) {
		lastname.sendKeys(strlastname);
	}
	
	@FindBy(xpath = "//input[@id='userName']")
	private WebElement userName;
	
	public void userName(String struserName) {
		userName.sendKeys(struserName);
	}
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	public void password(String strpassword) {
		password.sendKeys(strpassword);
	}
	
	@FindBy(xpath = "//button[@id='register']")
	private WebElement registerbtn;
	
	public void registerbtn() {
		registerbtn.click();
	}
	
	@FindBy(xpath = "//button[@id='login']")
	private WebElement Loginbtn;
	
	public void Loginbtn() {
		Loginbtn.click();
	}
	
	@FindBy(xpath = "//div[contains(text(),'Profile')]")
	private WebElement validateProfile;
	
	public String validateProfile() {
		return validateProfile.getText();
	}
	
	
	
	
}
