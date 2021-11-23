package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptClickPage {
	WebDriver driver;

	public JavaScriptClickPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'BUTTON CLICKS')]")
	private WebElement ButtonClicks;
	
	@FindBy(xpath = "//span[@id='button2']")
	private WebElement ClickMeOne;
	
	@FindBy(xpath = "//body/div[1]/div[5]/div[1]/div[1]/div[3]/button[1]")
	private WebElement CloseButton;
	
	@FindBy(xpath = "//h4[contains(text(),'Well I think it is.....')]")
	private WebElement DisplayMessage;
	
	public String DisplayMessage() {
		return DisplayMessage.getText();
	}
	
	public void ButtonClicks() {
		ButtonClicks.click();
	}
	
	public void ClickMeOne() {
		ClickMeOne.click();
	}
	
	public void CloseButton() {
		CloseButton.click();
	}

}

