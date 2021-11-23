package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement UsernameTxt;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement PasswordTxt;
	
	@FindBy(xpath = "//button[@id='login']")
	private WebElement Loginbtn;
	
	@FindBy(xpath = "//div[contains(text(),'Profile')]")
	private WebElement validateProfile;
	
	public void Loginbtn() {
		Loginbtn.click();
	}
	
	public String validateProfile() {
		return validateProfile.getText();
	}
	
	
	public void setUsername(String username) {
		UsernameTxt.sendKeys(username);
	}
	
	public void setPassword(String password) {
		PasswordTxt.sendKeys(password);
	}
	

}
