package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindowsBrowserwindowsPage {
	WebDriver driver;

	public AlertsFrameWindowsBrowserwindowsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/span[1]/div[1]/div[1]")
	private WebElement AlertsFrameWindowsarrowbtn;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]")
	private WebElement BrowserWindows;
	
	@FindBy(xpath = "//button[@id='windowButton']")
	private WebElement NewWindowbtn;
	
	@FindBy(xpath = "//h1[@id='sampleHeading']")
	private WebElement sampleHeading;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[4]")
	private WebElement NestedFrames;
	
	@FindBy(tagName = "body")
	private WebElement iFrameslocator;
	
	@FindBy(id ="frame1")
	private WebElement frame;
	
	
	@FindBy(tagName ="iframe")
	private List<WebElement> iframe;
	
	public void NestedFrames(){
		NestedFrames.click();
	}
	
	public List<WebElement> iframe(){
		return iframe;
	}
	
	public WebElement frame(){
		return frame;
	}
	
	public WebElement iFrameslocator(){
		return iFrameslocator;
	}
	
	public String iFramestext(){
		return iFrameslocator.getText();
	}
	
	public void AlertsFrameWindowsarrowbtn(){
		AlertsFrameWindowsarrowbtn.click();
	}
	
	public void BrowserWindows(){
		BrowserWindows.click();
	}
	
	public void NewWindowbtn(){
		NewWindowbtn.click();
	}
	
	public String sampleHeading(){
		return sampleHeading.getText();
	}
	
	
	
	
}
