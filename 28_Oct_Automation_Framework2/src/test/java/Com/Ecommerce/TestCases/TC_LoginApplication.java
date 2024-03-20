package Com.Ecommerce.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClasses.LoginTestCases;

public class TC_LoginApplication extends Ecommerce_BaseClass {
	@Test
	public void Login() {
		
		LoginTestCases LT = new LoginTestCases();
		
		LT.LoginButton();
		logger.info("Click on the login button");
		//logger.info("Click on the Login button");
		LT.SetUserEmail(Username);
	     logger.info("Enter the user  email");
		
		LT.SetUserPass(password);
	    logger.info("Enter the user password");

		LT.userLoginButton();
	    logger.info("Click on the user login button");

		String Title = driver.getTitle();
		
	      if  (Title.equals("nopCommerce demo store")) {
	    	  
	    	  AssertJUnit.assertTrue(true);
	    	  logger.info("Login test case pass");
	      }
	      else {
	    	  AssertJUnit.assertTrue(false);
	    	  logger.info("Login test case failed");

	      }
	}
}
