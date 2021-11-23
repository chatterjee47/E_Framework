package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {
	WebDriver driver;

	public WebTablesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Web Tables')]")
	private WebElement WebTablesbtn;
	
	@FindBy(xpath = "//button[@id='addNewRecordButton']")
	private WebElement addNewRecordButton;
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;
	
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;
	
	
	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement userEmail;
	
	
	@FindBy(xpath = "//input[@id='age']")
	private WebElement age;
	
	
	@FindBy(xpath = "//input[@id='salary']")
	private WebElement salary;
	
	@FindBy(xpath = "//input[@id='department']")
	private WebElement department;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submitbtn;
	
	
	public void WebTablesbtn(){
		WebTablesbtn.click();
	}
	
	public void addNewRecordButton(){
		addNewRecordButton.click();
	}
	
	public void setFirstName(String value){
		firstName.sendKeys(value);
	}
	
	public String getFirstName(){
		return firstName.getAttribute("value");
	}
	
	public void setlastName(String value){
		lastName.sendKeys(value);
	}
	
	public String getlastName(){
		return lastName.getAttribute("value");
	}
	
	public void setuserEmail(String value){
		userEmail.sendKeys(value);
	}
	
	public String getuserEmail(){
		return userEmail.getAttribute("value");
	}
	
	public void setage(String value){
		age.sendKeys(value);
	}
	
	public String getage(){
		return age.getAttribute("value");
	}
	
	public void setsalary(String value){
		salary.sendKeys(value);
	}
	
	public String getsalary(){
		return salary.getAttribute("value");
	}
	
	public void setdepartment(String value){
		department.sendKeys(value);
	}
	
	public String getdepartment(){
		return department.getAttribute("value");
	}
	
	public void submitbtn(){
		submitbtn.click();
	}
}
