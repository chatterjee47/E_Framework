package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Scrollingpage {
	WebDriver driver;

	public Scrollingpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'SCROLLING AROUND')]")
	private WebElement scrollingaroundlink;
	
	@FindBy(xpath = "//div[@id='zone4']")
	private WebElement VerifyTextX;
	
	
	public void scrollingaroundlink(){
		scrollingaroundlink.click();
	}
	
	public void ClickOnTextX(){
		VerifyTextX.click();
	}
	
	public WebElement VerifyTextX(){
		return VerifyTextX;
	}
	
}

