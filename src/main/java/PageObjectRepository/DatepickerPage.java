package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatepickerPage {
	WebDriver driver;

	public DatepickerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'DATEPICKER')]")
	private WebElement datepickerlink;
	
	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/span[1]")
	private WebElement calenderlink;
	
	public void datepickerlink() {
		datepickerlink.click();
	}
	
	public void calenderlink() {
		calenderlink.click();
	}
	
}
