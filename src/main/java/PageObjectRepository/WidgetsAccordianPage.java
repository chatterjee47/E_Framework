package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsAccordianPage {
	WebDriver driver;

	public WidgetsAccordianPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]")
	private WebElement WidgetsAccordianTab;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[1]")
	private WebElement AccordianTab;
	
	@FindBy(xpath = "//div[@id='section1Heading']")
	private WebElement WhatisLoremIpsum;
	
	@FindBy(xpath = "//div[@id='section2Heading']")
	private WebElement Wheredoesitcomefrom;
	
	@FindBy(xpath = "//div[@id='section3Heading']")
	private WebElement Whydoweuseit;
	
	@FindBy(xpath = "//p[contains(text(),'It is a long established fact that a reader will b')]")
	private WebElement WhydoweuseitMessage;
	
	public void WidgetsAccordianTab(){
		WidgetsAccordianTab.click();
	}
	
	public void AccordianTab(){
		AccordianTab.click();
	}
	
	public void WhatisLoremIpsum(){
		WhatisLoremIpsum.click();
	}
	
	public void Wheredoesitcomefrom(){
		Wheredoesitcomefrom.click();
	}
	
	public void Whydoweuseit(){
		Whydoweuseit.click();
	}
	
	public String WhydoweuseitMessage(){
		return WhydoweuseitMessage.getText();
	}
	
}
