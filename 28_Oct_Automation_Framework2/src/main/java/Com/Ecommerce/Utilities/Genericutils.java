package Com.Ecommerce.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class Genericutils extends Ecommerce_BaseClass {

	public static String getScreenshotAs(String TestCasename,WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String Name = "- Screenshot -" + Timestamp;

	    Path resourceDirectory = Paths.get("src","test","resources");
	    
		String AbsolutePath = resourceDirectory.toFile().getAbsolutePath();

		String Destination = AbsolutePath + "/Screenshots/"+Name+".png";

		FileUtils.copyFile(source, new File(Destination));

		return Destination;
	}
	

	public static void Clickonelementusingjavascriptexecutor(WebElement element,WebDriver driver) {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}
	
//	public static WebElement WaitforElement(WebDriver driver, WebElement Locator,int timeout ) {
//
//		WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		
//		Mywait.until(ExpectedConditions.presenceOfElementLocated(Locator));
//		
//		return driver.findElement(Locator);
//}
}
