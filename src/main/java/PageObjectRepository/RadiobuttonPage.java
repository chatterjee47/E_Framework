package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadiobuttonPage {
	WebDriver driver;

	public RadiobuttonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Radio Button')]")
	private WebElement Radiobutton;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]")
	private WebElement Impressiveradiobtn;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/p[1]")
	private WebElement DisplayImpressive;
	
	public void Radiobutton() {
		Radiobutton.click();
	}
	
	public void Impressiveradiobtn() {
		Impressiveradiobtn.click();
	}
	
	public String DisplayImpressive() {
		return DisplayImpressive.getText();
	}
	
	
}
