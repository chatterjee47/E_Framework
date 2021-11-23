package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage {
	WebDriver driver;

	public BookStorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[2]")
	private WebElement BookStoreLink;
	
	public void BookStoreLink() {
		BookStoreLink.click();
	}
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[3]")
	private WebElement ProfileLink;
	
	public void ProfileLink() {
		ProfileLink.click();
	}
	
	
	@FindBy(xpath = "//input[@id='searchBox']")
	private WebElement searchBox;
	
	public void searchBox(String strsearchBox) {
		searchBox.sendKeys(strsearchBox);
	}
	
	
	@FindBy(xpath = "(//*[@class='mr-2']/a)[1]")
	private WebElement Title_BookStore;
	
	public void Title_BookStore() {
		Title_BookStore.click();
	}
	
	public String Verify_BookStore() {
		return Title_BookStore.getText();
	}
	
	@FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
	private WebElement AddToYourCollection;
	
	public void AddToYourCollection() {
		AddToYourCollection.click();
	}
	
	
}
