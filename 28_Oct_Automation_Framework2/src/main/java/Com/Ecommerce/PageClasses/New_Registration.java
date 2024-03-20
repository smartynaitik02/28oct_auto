package Com.Ecommerce.PageClasses;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.Utilities.Genericutils;


public class New_Registration extends Ecommerce_BaseClass{
//1
	public New_Registration() {

	//PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, this);
	}

	//2
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	public WebElement Register;

	@FindBy(id = "gender-male")
	public WebElement Male;
	@FindBy(id = "gender-female")
	public WebElement FeMale;

	@FindBy(id = "FirstName")
	public WebElement Firstname;

	@FindBy(id = "LastName")
	public WebElement Lastname;

	@FindBy(id = "Email")
	public WebElement Email;

	@FindBy(id = "Password")
	public WebElement Password;

	@FindBy(id = "ConfirmPassword")
	public WebElement ConfirmPassword;
	
	@FindBy(id = "register-button")
	public WebElement registerbutton;
	
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	public WebElement RegSuccessfully;

	//3 .MEthod
	  
	public void Register() {
		Register.click();
	}
	
	public void Gender() {
		Male.click();
	}
	
	public void SetFirstname(String firstname) {
		Firstname.sendKeys(firstname);
	}
	public void Setlastname(String lastname) {
		Lastname.sendKeys(lastname);
	}
	public void SetEmail(String email) {
		Email.sendKeys(email);
		
	}
	
	public void SetPassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void SetConPassword(String Cpass) {
		ConfirmPassword.sendKeys(Cpass);
	}
	
	public void RegButton() {
		registerbutton.click();
	}
	
	public void verifyRegSuccessfully() throws IOException {
		
		boolean value = RegSuccessfully.isDisplayed();
		if(value == true) {
			System.out.println("RegSuccessfully");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Hello");
			Genericutils.getScreenshotAs("Registration Testcase", driver);
			Assert.assertTrue(false);
		}
	}
	
	// Test@gmail.com
	// Test@123
}
