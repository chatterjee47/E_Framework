package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectNMDatePage {
	WebDriver driver;

	public SelectNMDatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'DATEPICKER')]")
	private WebElement DATEPICKERlink;
	
	@FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/span[1]/i[1]")
	private WebElement calendertab;
	
	@FindBy(xpath = "//table[@class=' table-condensed']/thead/tr/th[@class='datepicker-switch']")
	private WebElement datepickerswitch_One;
	
	
	@FindBy(xpath = "//table[@class='table-condensed']/thead/tr/th[contains(@class,'datepicker-switch')]")
	private WebElement datepickerswitch_Two;
	
	@FindBy(xpath = "//table[@class='table-condensed']/tbody/tr/td/span[contains(@class,'year')]")
	private List<WebElement> yearselection;
	
	@FindBy(xpath = "//table[@class='table-condensed']/tbody/tr/td/span[contains(@class,'month')]")
	private List<WebElement> monthselection;
	
	@FindBy(xpath = "//table[@class=' table-condensed']/tbody/tr/td[contains(@class,'day')]")
	private List<WebElement> dateselection;
	
	@FindBy(xpath = "//div[@id='datepicker']/input")
	private WebElement datedisplay;
	
	
	public void DATEPICKERlink(){
		DATEPICKERlink.click();
	}
	
	public void calendertab(){
		calendertab.click();
	}
	
	public void datepickerswitch_One(){
		 datepickerswitch_One.click();;
	}
	
	public void datepickerswitch_Two(){
		datepickerswitch_Two.click();;
	}
	
	public List<WebElement> yearselection(){
		return yearselection;
	}
	
	public List<WebElement> dateselection(){
		return dateselection;
	}
	
	public List<WebElement> monthselection(){
		return monthselection;
	} 
	
	public String datedisplay(){
		return datedisplay.getAttribute("value");
	}
}
