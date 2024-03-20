package Com.Ecommerce.BaseClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Ecommerce.Configuration.Readconfiguration;
import Com.Ecommerce.Utilities.Genericutils;
import Com.Ecommerce.Utilities.WaitUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerce_BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	public Genericutils utils;

	Readconfiguration readconfig = new Readconfiguration();

	public String BaseURL  = readconfig.getApllicationURL();
	public String Username = readconfig.Username();
	public String password = readconfig.Password();

	@SuppressWarnings("deprecation")
	@BeforeMethod
	@Parameters("Browser")
	public void initialization(String Browsername) {

		logger = logger.getLogger("11March_Automation_Framework");

		PropertyConfigurator.configure(
				"C:\\28_Oct_Automation_Framework2\\src\\test\\resources\\Configuration\\log4j.properties");

		if (Browsername.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browsername.equals("FireFox")) {
//
			driver = new FirefoxDriver();
			
		} else if (Browsername.equals("Edge")) {
			driver = new EdgeDriver();
		}

		logger.info("Open browser");

		driver.manage().window().maximize();

		logger.info("Maximize the browser");

		driver.manage().timeouts().implicitlyWait(WaitUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(WaitUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(BaseURL);

		logger.info("Open application");
	}

	@AfterMethod
	public void Teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
