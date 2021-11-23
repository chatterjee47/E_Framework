package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsKeywordPage {
	WebDriver driver;

	public ButtonsKeywordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]")
	private WebElement ButtonsTab;
	
	@FindBy(xpath = "//button[@id='doubleClickBtn']")
	private WebElement doubleClickBtn;
	
	@FindBy(xpath = "//p[@id='doubleClickMessage']")
	private WebElement doubleClickMessage;
	
	@FindBy(xpath = "//button[@id='rightClickBtn']")
	private WebElement rightClickBtn;
	
	@FindBy(xpath = "//p[@id='rightClickMessage']")
	private WebElement rightClickMessage;
	
	
	
	public void getButtonsTab(){
		ButtonsTab.click();
	}
	
	public WebElement getdoubleClickBtn(){
		return doubleClickBtn;
	}
	
	public WebElement getrightClickBtn(){
		return rightClickBtn;
	}
	
	public WebElement doubleClickMessage(){
		return doubleClickMessage;
	}
	
	public WebElement rightClickMessage(){
		return rightClickMessage;
	}
	
	
}
