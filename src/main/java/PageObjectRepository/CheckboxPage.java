package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {
	WebDriver driver;

	public CheckboxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")
	private WebElement Checkboxbtn;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/span[1]/button[1]/*[1]")
	private WebElement Togglebtn;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[3]/span[1]/button[1]/*[1]")
	private WebElement ToggleDownload;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[3]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")
	private WebElement WordFile;
	
	@FindBy(xpath = "//span[contains(text(),'wordFile')]")
	private WebElement displayWordFile;
	
	public void Checkboxbtn() {
		Checkboxbtn.click();
	}
	
	public void Togglebtn() {
		Togglebtn.click();
	}
	
	public void ToggleDownload() {
		ToggleDownload.click();
	}
	
	public void WordFile() {
		WordFile.click();
	}
	
	public WebElement displayWordFile() {
		return displayWordFile;
	}
	
}
