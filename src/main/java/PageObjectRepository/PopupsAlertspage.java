package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupsAlertspage {
	WebDriver driver;

	public PopupsAlertspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'POPUP & ALERTS')]")
	private WebElement PopupsAlertslink;
	
	@FindBy(xpath = "//span[@id='button1']")
	private WebElement JavaScriptAlert;
	
	@FindBy(xpath = "//span[@id='button2']")
	private WebElement ModalPopup;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement ModalPopupClosebtn;
	
	@FindBy(xpath = "//body/div[1]/div[6]/div[1]/div[1]/div[2]/p[1]")
	private WebElement ModalPopupMessage;
	
	
	
	public void PopupsAlertslink() {
		PopupsAlertslink.click();
	}
	
	public void JavaScriptAlert() {
		JavaScriptAlert.click();
	}
	
	public void ModalPopup() {
		ModalPopup.click();
	}
	
	public void ModalPopupClosebtn() {
		ModalPopupClosebtn.click();
	}
	
	public WebElement ModalPopupMessage() {
		return ModalPopupMessage;
	}
}
