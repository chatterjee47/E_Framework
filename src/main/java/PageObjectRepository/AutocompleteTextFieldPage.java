package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutocompleteTextFieldPage {
	WebDriver driver;

	public AutocompleteTextFieldPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'AUTOCOMPLETE TEXTFIELD')]")
	private WebElement AutocompleteTextFieldlink;
	
	@FindBy(xpath = "//input[@id='myInput']")
	private WebElement FoodItem;
	
	@FindBy(xpath = "//div[@id='myInputautocomplete-list']/div")
	private WebElement myInputautocompleteList;
	
	public void AutocompleteTextFieldlink() {
		AutocompleteTextFieldlink.click();
	}
	
	public void FoodItem(String value) {
		FoodItem.sendKeys(value);
	}
	
	public WebElement myInputautocompleteList() {
		return myInputautocompleteList;
	 
     }
	
	
}
