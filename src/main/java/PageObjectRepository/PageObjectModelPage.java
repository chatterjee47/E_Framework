package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModelPage {
	WebDriver driver;

	public PageObjectModelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'PAGE OBJECT MODEL')]")
	private WebElement PAGEOBJECTMODELClicks;
	
	@FindBy(xpath = "//a[contains(text(),'Our Products')]")
	private WebElement OurProducts;
	
	@FindBy(xpath = "//p[contains(text(),'New Laptops')]")
	private WebElement NewLaptops;
	
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")
	private WebElement Proceedbtn;
	
	@FindBy(xpath = "//p[contains(text(),'Desktop Systems')]")
	private WebElement DesktopSystems;
	
	@FindBy(xpath = "//b[contains(text(),'NEWCUSTOMER773322')]")
	private WebElement VerifyText;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement Closebtn;
	
	
	public void PAGEOBJECTMODELClicks() {
		PAGEOBJECTMODELClicks.click();
	}
	
	public void OurProducts() {
		OurProducts.click();
	}
	
	public void NewLaptops() {
		NewLaptops.click();
	}
	
	public void Proceedbtn() {
		Proceedbtn.click();
	}
	
	public void DesktopSystems() {
		DesktopSystems.click();
	}
	
	public String VerifyText() {
		return VerifyText.getText();
	}
	
	public void Closebtn() {
		Closebtn.click();
	}

}
