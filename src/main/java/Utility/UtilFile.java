package Utility;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UtilFile {
	WebDriver driver;
	static String parentId;
	static String childId;

	public UtilFile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void rightclickOpenWindow(WebElement elementLocator){
		Actions actions = new Actions(driver);
		actions.contextClick(elementLocator).sendKeys(Keys.CONTROL).click(elementLocator).perform();
		pause(1000);
	}
	
	public void rightclickOpenWindows(WebElement elementLocator){
	Actions act = new Actions(driver);
	act.contextClick(elementLocator).perform();  // right click
	act.sendKeys(Keys.ARROW_DOWN).click(elementLocator).perform();
	}
	
	public void doubleclick(WebElement elementLocator){
		Actions actions = new Actions(driver);
		actions.doubleClick(elementLocator).perform();
	}
	
	public void rightclick(WebElement elementLocator){
	Actions actions = new Actions(driver);
	actions.contextClick(elementLocator).perform();
	}
	
	 //Get The Current Day
    public String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
       
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
    }

	public void tomorrowdatepicker(String value){
		//This are the columns of the from date picker table
        List<WebElement> columns = driver.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            //Select Today's Date
            if (cell.getText().equals(value)) {
                cell.click();
                break;
            }
        }
	}
	
	public void WindowHandle() {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		parentId = it.next();
		childId = it.next();
	}

	public void ChildWindow() {
		driver.switchTo().window(childId);
	}

	public void ParentWindow() {
		driver.switchTo().window(parentId);
		
	
	}

	public void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ActionKeyword(WebElement locatorfrom, WebElement locatorone) {
		// Actions class method to drag and drop
		Actions builder = new Actions(driver);
		// Perform drag and drop
		builder.dragAndDrop(locatorfrom, locatorone).perform();
	}
	
	public void MouseOver(WebElement locatorfrom, WebElement locatorto) {
		// Actions class method to drag and drop
		Actions builder = new Actions(driver);
		// Perform drag and drop
		builder.moveToElement(locatorfrom).moveToElement(locatorto).click().build().perform();
	}

	
	public void ClickAndHold(WebElement locator) {
		// Actions class method to drag and drop
		Actions builder = new Actions(driver);
		// Perform click and hold
		builder.clickAndHold(locator).perform(); 
	}

	public void scrolltobottom(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollTop(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-9000)");
	}
	
	public void scrollDown(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,5000)");
	}
	
	public void scrollToView(WebElement locator){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locator);
	}
	
	public void switchToIframe(WebElement locator){
		driver.switchTo().frame(locator);
	}

	
	public void pageload(){
		// Sleep until the div we want is visible or 5 seconds is over
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
		    // Browsers which render content (such as Firefox and IE) return "RenderedWebElements"
		    WebElement resultsDiv =  driver.findElement(By.className("gac_m"));

		    // If results have been returned, the results are displayed in a drop down.
		    if (resultsDiv.isDisplayed()) {
		      break;
		    }
		}
	}
	
	static String locatelement= "//div[@class='rt-tbody']/div[4]/div/div";
	public void verifydatainfor(String value){
	List<WebElement> listdata = driver.findElements(By.xpath(locatelement));
	
	// List<String> list=new ArrayList<String>();  
	
	
	int count = listdata.size();
	System.out.println("******************************");
    for(int i=0;i<count;i++){
    	listdata.get(i).getText();
    	if(listdata.get(i).getText().contains(value))
    	{
    		System.out.println(value + " is Present in webtable");
    	}
    }
	}
	
	
	public void verifydata(List<WebElement> locator, String value){
		List<WebElement> Autocompletelists = locator;
		int count = Autocompletelists.size();
	//	System.out.println("count of data present : " + count);
		for (int i = 0; i <count; i++) {
			String actualdata = Autocompletelists.get(i).getText();
		//	System.out.println(actualdata);
		//	pause(1000);
			if (actualdata.equals(value)) {
		//		pause(1000);
				Autocompletelists.get(i).click();
				break;
			}
		}
	}
	
	
	static String locator= "//div[@id='myInputautocomplete-list']/div";
	public void verifyautoselect(){
		List<WebElement> Autocompletelists = driver.findElements(By.xpath(locator));
		int count = Autocompletelists.size();
		for (int i = 0; i < count; i++) {
			String actualdata = Autocompletelists.get(i).getText();
			System.out.println(actualdata);
			if (actualdata.equals("Pizza")) {
				
				System.out.println("Pizza displayed");
				Assert.assertEquals(actualdata, "Pizza");
			}
			if (actualdata.equals("Pepperoni")) {
			
				System.out.println("Pepperoni displayed");
				Assert.assertEquals(actualdata, "Pepperoni");
			}
			if (actualdata.equals("Pancakes")) {
				
				System.out.println("Pancakes displayed");
				Assert.assertEquals(actualdata, "Pancakes");
			}
		}
	}
	

}
