package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyWebsitesPage {
	WebDriver driver;

	public VerifyWebsitesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[contains(text(),'Login Portal')]")
	private WebElement LoginPortallink;
	
	@FindBy(xpath = "//div[contains(text(),'Kitchens')]")
	private WebElement Kitchenstab;
	
	@FindBy(xpath = "//div[contains(text(),'Kitchens')]/parent::li/ul/li[4]/a")
	private WebElement EnglandEight;
	
	@FindBy(xpath = "//div[contains(text(),'Kitchens')]/parent::li/ul/li[5]/a")
	private WebElement EnglandNine;
	
	public void clickOnLoginPortal() {
		LoginPortallink.click();
	}
	
	public void Kitchenstab() {
		Kitchenstab.click();
	}
	
	public void EnglandEight() {
		EnglandEight.click();
	}
	
	public void EnglandNine() {
		EnglandNine.click();
	}
	
}
