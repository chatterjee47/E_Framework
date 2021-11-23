package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {

	static WebDriver driver;

	public static WebDriver StartBrowser(String browsername, String url) throws InterruptedException {
		if (browsername.equalsIgnoreCase("Firefox")) {
			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.gecko.driver",path+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
		}
		else if (browsername.equalsIgnoreCase("Chrome")) {
			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		}
		else if (browsername.equalsIgnoreCase("IE")) {
			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.ie.driver",path+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	}