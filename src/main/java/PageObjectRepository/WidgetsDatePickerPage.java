package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsDatePickerPage {
	WebDriver driver;

	public WidgetsDatePickerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]")
	private WebElement WidgetTab;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[3]")
	private WebElement DatePickertab;
	
	@FindBy(xpath = "//input[@id='dateAndTimePickerInput']")
	private WebElement dateAndTimePickerInput;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	private WebElement monthtab;
	
	@FindBy(xpath = "//div[@class='react-datepicker__month-dropdown']/div")
	private List<WebElement> monthselector;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]")
	private WebElement dateselector;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")
	private WebElement yeartab;
	
	@FindBy(xpath = "//div[@class='react-datepicker__year-dropdown']/div")
	private List<WebElement> yearselector;
	
	
	@FindBy(xpath = "//ul[@class='react-datepicker__time-list']/li")
	private List<WebElement> timeelector;
	

	
	public List<WebElement> monthselector(){
		return monthselector;
	}
	
	public List<WebElement> yearselector(){
		return yearselector;
	}
	
	public List<WebElement> timeelector(){
		return timeelector;
	}
	
	
	public void WidgetTab(){
		WidgetTab.click();
	}
	
	public void dateselector(){
		dateselector.click();
	}
	
	public void DatePickertab(){
		DatePickertab.click();
	}
	
	public void dateAndTimePickerInput(){
		dateAndTimePickerInput.click();
	}
	
	public void monthtab(){
		monthtab.click();
	}
	
	public void yeartab(){
		yeartab.click();
	}
	
	public String verifydateAndTimePickerInput(){
		return dateAndTimePickerInput.getAttribute("value");
	}
	
}
