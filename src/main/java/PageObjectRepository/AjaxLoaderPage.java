package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjaxLoaderPage {
	WebDriver driver;

	public AjaxLoaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'AJAX LOADER')]")
	private WebElement AjaxLoaderlink;
	
	@FindBy(xpath = "//p[contains(text(),'CLICK ME!')]")
	private WebElement ClickMebtn;
	
	@FindBy(xpath = "//h4[contains(text(),'Well Done For Waiting....!!!')]")
	private WebElement VerifyTextOne;//Well Done For Waiting....!!!
	
	@FindBy(xpath = "//p[contains(text(),'The waiting game can be a tricky one; this exercis')]")
	private WebElement VerifyTextTwo;
	//The waiting game can be a tricky one; this exercise will hopefully improve your understandings of the various types of waits.
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement Closebtn;
	
	public void AjaxLoaderlink() {
		AjaxLoaderlink.click();
	}
	
	public void ClickMebtn() {
		ClickMebtn.click();
	}
	
	public String VerifyTextOne() {
		return VerifyTextOne.getText();
	}
	
	public String VerifyTextTwo() {
		return VerifyTextTwo.getText();
	}
	
	public void Closebtn() {
		Closebtn.click();
	}
}
