package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class IFramepage {
	WebDriver driver;

	public IFramepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'IFRAME')]")
	private WebElement iframelink;
	
	@FindBy(xpath = "//iframe[@id='frame']")
	private WebElement frame;
	
	
	@FindBy(xpath = "//b[contains(text(),'Find Out More!')]")
	private WebElement findoutmore;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement Closefindoutmore;
	
	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement ContactUs;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[1]")
	private WebElement FirstName;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[2]")
	private WebElement LastName;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[3]")
	private WebElement EmailAddress;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/textarea[1]")
	private WebElement Comments;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/div[1]/input[2]")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//body/div[@id='nav-container']/div[@id='myModal']/div[1]/div[1]/div[1]/h4[1]")
	private WebElement Modal;
	
	@FindBy(xpath = "//a[@id='nav-title']")
	private WebElement IframeTitle;
	
	public void FirstName(String data) {
		FirstName.sendKeys(data);
	}
	
	public void LastName(String data) {
		LastName.sendKeys(data);
	}
	
	public void EmailAddress(String data) {
		EmailAddress.sendKeys(data);
	}
	
	public void Comments(String data) {
		Comments.sendKeys(data);
	}
	
	public void ContactUs() {
		ContactUs.click();
	}
	
	public void submitbtn() {
		submitbtn.click();
	}
	
	public void iframelink() {
		iframelink.click();
	}
	
	public void findoutmore() {
		findoutmore.click();
	}
	
	public void Closefindoutmore() {
		Closefindoutmore.click();
	}
	
	public WebElement MoveToClosefindoutmore() {
		return Closefindoutmore;
	}
	
	public WebElement frame() {
		return frame;
	}
	
	public WebElement IframeTitle() {
		return IframeTitle;
	}
	
	public WebElement Modal() {
		return Modal;
	}
	
	public void verifyError(){
		List<WebElement> str = driver.findElements(By.tagName("body"));
		int count = str.size();
		for(int i=0;i<count;i++){
			System.out.println(str.get(i).getText());
			Assert.assertEquals("Error: Invalid email address", str.get(i).getText());
		}
	}
	
}
