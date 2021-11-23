package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {
	WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'FILE UPLOAD')]")
	private WebElement FileUploadlink;
	
	@FindBy(xpath = "//input[@id='myFile']")
	private WebElement ChooseFile;
	
	@FindBy(xpath = "//input[@id='submit-button']")
	private WebElement submitbutton;
	
	public void FileUploadlink(){
		FileUploadlink.click();
	}
	

	
	public void ChooseFile(String value){
		ChooseFile.sendKeys(value);
	}
	
	public void submitbutton(){
		submitbutton.click();
	}
	
}
