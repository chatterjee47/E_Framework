package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionsPage_Scenarios {
	WebDriver driver;

	public ActionsPage_Scenarios(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // 
	}

	@FindBy(xpath = "//h1[contains(text(),'ACTIONS')]")
	private WebElement Actionslink;
	
	@FindBy(id = "draggable")
	private WebElement locatorfrom;
	
	@FindBy(id = "droppable")
	private WebElement locatorone;
	
	
	@FindBy(xpath = "//div[@id='double-click']")
	private WebElement doubleclick;
	
	@FindBy(xpath = "//button[contains(text(),'Hover Over Me First!')]")
	private WebElement HoverOverMeFirst;
	
	@FindBy(xpath = "//body/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]")
	private WebElement linkone;
	
	@FindBy(xpath = "//div[@id='click-box']")
	private WebElement ClickHold;
	
	@FindBy(xpath = "//button[contains(text(),'Hover Over Me Third!')]")
	private WebElement HoverOverMeThird;
	
	@FindBy(xpath = "//body/div[1]/div[4]/div[1]/div[3]/div[1]/a[1]")
	private WebElement HoverOverMeThirdlink;
	
	
	
	
	
	public WebElement HoverOverMeThirdlink() {
		return HoverOverMeThirdlink;
	}
	
	
	public WebElement HoverOverMeThird() {
		return HoverOverMeThird;
	}
	
	public WebElement ClickHold() {
		return ClickHold;
	}
	
	public void doubleclick() {
		doubleclick.click();
	}

	public WebElement linkone() {
		return linkone;
	}
	
	public WebElement HoverOverMeFirst(){
		return HoverOverMeFirst;
	}
	
	public void Actionslink() {
		Actionslink.click();
	}

	public WebElement locatorfrom(){
		return locatorfrom;
	}
	
	public WebElement locatorone(){
		return locatorone;
	}
}
