package Com.Ecommerce.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class LoginTestCases extends Ecommerce_BaseClass {

	// Akash123@gmail.com
	// Java@123

	public LoginTestCases() {

		PageFactory.initElements(driver, this);

	}
	//
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	public WebElement Login;

	@FindBy(id = "Email")
	public WebElement UserEmail;

	@FindBy(id = "Password")
	public WebElement Userpass;

	@FindBy(xpath = "//button[@type=\"submit\" and @class=\"button-1 login-button\"]")
	public WebElement Userloginbutton;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	public WebElement LoginBtn;	
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	public WebElement Logout;

	public void LoginButton() {

		Login.click();
	}

	public void SetUserEmail(String name) {

		UserEmail.sendKeys(name);

	}

	public void SetUserPass(String Pass) {

		Userpass.sendKeys(Pass);
	}

	public void userLoginButton() {

		Userloginbutton.click();
		
	}
	public void Logout() {
		Logout.click();
	}

}
