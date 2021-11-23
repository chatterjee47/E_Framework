package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionMoveClickPage {
	WebDriver driver;

	public ActionMoveClickPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'BUTTON CLICKS')]")
	private WebElement ButtonClicks;
	
	@FindBy(xpath = "//span[@id='button3']")
	private WebElement ClickMeOne;
	
	@FindBy(xpath = "//body/div[1]/div[6]/div[1]/div[1]/div[3]/button[1]")
	private WebElement CloseButton;
	
	@FindBy(xpath = "//body/div[1]/div[6]/div[1]/div[1]/div[1]/h4[1]/b[1]")
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

