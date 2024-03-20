package Com.Ecommerce.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClasses.LoginTestCases;
import Com.Ecommerce.PageClasses.TC_Ecommerce_AddToCart;

public class TC_AddToCart extends Ecommerce_BaseClass {

	@Test
	public void AddProduct() throws InterruptedException {

//		logger.info("Open application URL");
//		LoginTestCases LT = new LoginTestCases();
//
//		LT.LoginButton();
//		logger.info("Click on the login button");
//		// logger.info("Click on the Login button");
//		LT.SetUserEmail();
//		logger.info("Enter the user  email");
//
//		LT.SetUserPass();
//		logger.info("Enter the user password");
//
//		LT.userLoginButton();
//		logger.info("Click on the user login button");
//		
		TC_Ecommerce_AddToCart TEA = new TC_Ecommerce_AddToCart();
		
		//Action & Actions
		
		Actions Act = new Actions(driver);

		WebElement Computer = driver.findElement(By.xpath("//a[contains(text(),'Computers ')]"));

		Act.moveToElement(Computer).perform();
		
		logger.info("Mouseover on computer");

		TEA.NoteBook();
		logger.info("Clicked on NotebookText");

		
		Thread.sleep(5000);
		
		TEA.SelectProduct();
		logger.info("Product selected");

		TEA.AdsToCart();
		logger.info("Add to cart");

		TEA.ProductAdded();
		logger.info("Verified message");

		TEA.Close();
		logger.info("Clciked on close Tab");

		WebElement Ele=driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
				
		Actions act = new Actions(driver);

		act.moveToElement(Ele).build().perform();
		
		
	}
}
