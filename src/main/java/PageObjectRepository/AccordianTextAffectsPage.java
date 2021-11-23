package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccordianTextAffectsPage {
	WebDriver driver;

	public AccordianTextAffectsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'ACCORDION & TEXT AFFECTS (APPEAR & DISAPPEAR)')]")
	private WebElement AccordianTextAffectslink;
	
	@FindBy(xpath = "//button[@id='manual-testing-accordion']")
	private WebElement manualtestingbtn;
	
	@FindBy(xpath = "//p[contains(text(),'Manual testing has for some time been the most pop')]")
	private WebElement VerifyManualtestingText;
	
	//Manual testing has for some time been the most popular way to test code. For this method, the tester plays an important role of end user and verifies that all the features of the application work correctly. Manual testing however is on the decline. Companies and developers have realised the efficiency, accuracy and cost savings that is possible by adopting the use of automation testing.
	
	@FindBy(xpath = "//button[@id='cucumber-accordion']")
	private WebElement cucumberBDD;
			
			@FindBy(xpath = "//p[contains(text(),'Cucumber (BDD) simplifies the requirement capturin')]")
			private WebElement VerifycucumberBDDText;		
			//Cucumber (BDD) simplifies the requirement capturing process. Requirements can be captured, broken down and simplified effortlessly; making the captured requirements readable to anyone within the organisation and in turn providing the required details and backbone to develop accurate test cases also known as ‘Feature Files’.
			
		
		
	
	public void AccordianTextAffectslink() {
		AccordianTextAffectslink.click();
	}
	
	public void manualtestingbtn() {
		manualtestingbtn.click();
	}
	
	public String VerifyManualtestingText() {
		return VerifyManualtestingText.getText();
	}
	
	public void cucumberBDD() {
		cucumberBDD.click();
	}

	public String VerifycucumberBDDText() {
		return VerifycucumberBDDText.getText();
	}
}

