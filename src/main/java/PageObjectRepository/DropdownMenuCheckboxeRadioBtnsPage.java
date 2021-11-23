package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class DropdownMenuCheckboxeRadioBtnsPage {
	
	
	WebDriver driver;

	public DropdownMenuCheckboxeRadioBtnsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)')]")
	private WebElement DropdownMenuCheckboxeRadioBtnsClicks;
	
	@FindBy(xpath = "//select[@id='dropdowm-menu-1']")
	private WebElement dropdowmmenuone;
	
	@FindBy(xpath = "//select[@id='dropdowm-menu-2']")
	private WebElement dropdowmmenutwo;
	
	@FindBy(xpath = "//select[@id='dropdowm-menu-3']")
	private WebElement dropdowmmenuthree;
	
	@FindBy(xpath = "//body/div[1]/div[3]/div[1]/div[1]/label[3]/input[1]")
	private WebElement checkboxthree;
	
	@FindBy(xpath = "//body/div[1]/div[3]/div[1]/div[1]/label[4]/input[1]")
	private WebElement checkboxfour;
	
	@FindBy(xpath = "//body/div[1]/div[5]/div[1]/div[1]/form[1]/input[2]")
	private WebElement SelectedDisabledCabbageradiobtn;
	
	@FindBy(xpath = "//select[@id='fruit-selects']")
	private WebElement SelectedDisableddropdown;
	
	@FindBy(xpath = "//body/div[1]/div[4]/div[1]/div[1]/form[1]/input[4]")
	private WebElement Orangeradiobtn;
	
	
	public void DropdownMenuCheckboxeRadioBtnsClicks() {
		DropdownMenuCheckboxeRadioBtnsClicks.click();
	}
	
	public WebElement dropdowmmenuone() {
		return dropdowmmenuone;
	}
	
	public WebElement dropdowmmenutwo() {
		return dropdowmmenutwo;
	}
	
	public WebElement dropdowmmenuthree() {
		return dropdowmmenuthree;
	}
	
	public void checkboxthree() {
		checkboxthree.click();
	}
	
	public void checkboxfour() {
		checkboxfour.click();
	}
	
	public void SelectedDisabledCabbageradiobtn() {
		SelectedDisabledCabbageradiobtn.click();
	}
	
	
	public WebElement SelectedDisableddropdown(){
		return SelectedDisableddropdown;
	}
	
	public WebElement Orangeradiobtn() {
		return Orangeradiobtn;
	}
	
	public void Selectdropdown(WebElement dropdownoption , String Value){
		Select dropdowmmenuone = new Select(dropdownoption);
		dropdowmmenuone.selectByVisibleText(Value);
	}
}
