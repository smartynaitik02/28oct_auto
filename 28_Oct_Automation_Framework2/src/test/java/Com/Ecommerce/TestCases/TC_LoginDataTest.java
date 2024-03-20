package Com.Ecommerce.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClasses.TC_Ecommerce_Login_Page;
import Com.Ecommerce.Utilities.XLSUtils;

public class TC_LoginDataTest extends Ecommerce_BaseClass {

	@Test(dataProvider = "Logindata")
	public void LoginData(String user,String PWD,String Expected) throws InterruptedException {

		TC_Ecommerce_Login_Page TEL = new TC_Ecommerce_Login_Page();

		TEL.SetUsername(user);
		logger.info("Enter the user email");

		Thread.sleep(2000);

		TEL.SetPassword(PWD);
		logger.info("Enter the user password");

		TEL.ClickButton();
		logger.info("Click on the login button");

		String Act_Title = driver.getTitle();
        String Exp_Title ="nopCommerce demo store";
        
		if (Expected.equals("Valid")) {
			
             if(Act_Title.equals(Exp_Title)) {
            	 TEL.Logout();
			Assert.assertTrue(true);
			 logger.info("Login test case pass");
             
             }    
             else {
     			Assert.assertTrue(false);
    			 logger.info("Login test case failed");
    			 
             }
			
		} else if(Expected.equals("Invalid")) {
			if(Act_Title.equals(Exp_Title)) {
           	 TEL.Logout();
 			Assert.assertTrue(false);
			 logger.info("Login test case pass");
            }
            else {
    			Assert.assertTrue(true);
   			 logger.info("Login test case failed");
            }
            }
	}

	@DataProvider(name ="Logindata")
	public String[][] getdata() throws IOException {
		
		String path= System.getProperty("user.dir")+"/src/main/java/Com/Ecommerce/TestData/28_oct_testdta.xlsx";

		System.out.println(path);
	  //  String path ="/Users/ranjeetkendre/eclipse-workspace/28_Oct_Automation_Framework2/src/main/java/Com/Ecommerce/TestData/Untitled spreadsheet (6).xlsx";
		int rownum=XLSUtils.getRowcount(path, "Sheet1");   //5  3
		
		int Colcount=XLSUtils.getCellcount(path, "Sheet1",2); 
		                                        
            String logindata[][] = new String [rownum][Colcount];
            
            for(int i=1;i<=rownum;i++) {  //1   5<=5 ;i++
            	
            	for(int j=0 ;j<Colcount ;j++) {
            		
            		logindata[i-1][j]=XLSUtils.getcelldata(path, "Sheet1", i, j);  //5
            	}
            }
            return logindata;
		
	}
}
