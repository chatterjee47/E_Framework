package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPortalPage {
	WebDriver driver;
	
	public LoginPortalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//h4[contains(text(),'Login Portal')]")
	private WebElement LoginPortallink;

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement UsernameText;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement PasswordText;
	
	@FindBy(xpath = "//button[@id='login-button']")
	private WebElement LoginButton;
	
	public void clickOnLoginPortal() {
		LoginPortallink.click();
	}
	
	public void setUsername(String username) {
		UsernameText.sendKeys(username);
	}
	
	public void setPassword(String password) {
		PasswordText.sendKeys(password);
	}
	
	public void ClickOnLoginButton() {
		LoginButton.click();
	}
}
