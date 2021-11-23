package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class admindemoWebSiteFeaturePage {
	WebDriver driver;

	public admindemoWebSiteFeaturePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement EmailAddress;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement Password;
	
	@FindBy(xpath = "//body/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li[2]/a/span[contains(text(),'Catalog')]")
	private WebElement catalogbtn;
	
	@FindBy(xpath = "//ul[@class='treeview-menu']/li[1]/a/span[contains(text(),'Products')]")
	private WebElement products;
	
	@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li[4]/a/span[contains(text(),'Customers')]")
	private WebElement customers;
	
	@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li[4]/ul/li[2]/a/span[contains(text(),'Customer roles')]")
	private WebElement customerroles;

	
	@FindBy(xpath = "//span[contains(text(),'Online customers')]")
	private WebElement onlinecustomers;
	
	public void setEmailAddress(String value){
		EmailAddress.clear();
		EmailAddress.sendKeys(value);
	}
	
	public void setPassword(String value){
		Password.clear();
		Password.sendKeys(value);
	}
	
	public void LoginButton(){
		LoginButton.click();;
	}
	
	public void catalogbtn(){
		catalogbtn.click();;
	}
	
	public void onlinecustomers(){
		onlinecustomers.click();;
	}

	public WebElement products(){
		return products;
	}
	
	public WebElement customerroles(){
		return customerroles;
	}
	
	public void customers(){
		customers.click();;
	}
	
}
