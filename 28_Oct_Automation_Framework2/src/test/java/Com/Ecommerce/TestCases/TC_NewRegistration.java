package Com.Ecommerce.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClasses.New_Registration;
import net.bytebuddy.utility.RandomString;

public class TC_NewRegistration extends Ecommerce_BaseClass {

	@Test
	public void Registration() throws IOException {

		New_Registration NR = new New_Registration();

		NR.Register();
		logger.info("Click on Regiset button");
		NR.Gender();
		logger.info("Click on the gender");

		NR.SetFirstname("Vishal");
		logger.info("Enter the first name");

		NR.Setlastname("Patil");
		logger.info("Enter the last name");
		String Name = RandomString.make(5);

		NR.SetEmail(Name + "Patil@gmail.com");

		NR.SetPassword("Java@123");
		
		logger.info("Set the password ");
		
		NR.SetConPassword("Java@123");
		
		logger.info("conf the password ");
		NR.RegButton();
		
		logger.info("Click on regbutton");
		NR.verifyRegSuccessfully();
		
		logger.info("Verify verify Reg message");
	}

}
