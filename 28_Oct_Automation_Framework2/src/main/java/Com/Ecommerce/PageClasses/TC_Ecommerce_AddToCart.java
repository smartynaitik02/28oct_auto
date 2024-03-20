package Com.Ecommerce.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

import Com.Ecommerce.Utilities.Genericutils;


public class TC_Ecommerce_AddToCart extends Ecommerce_BaseClass {

	public TC_Ecommerce_AddToCart() {
		
		PageFactory.initElements(driver, this);
		//Class .static method
	}	

	@FindBy(xpath = "//a[contains(text(),'Computers ')]")
	public WebElement Com;
	
	@FindBy(xpath = "//a[contains(text(),'Notebooks ')]")
	public WebElement Notebook;
	
	@FindBy(xpath = "//a[contains(text(),'Apple MacBook Pro 13-inch')]")
	public WebElement SelectMackbook;
	
	@FindBy(id = "add-to-cart-button-4")
	private WebElement Addtocart;
	
	@FindBy(xpath = "//p[contains(text(),'The product has been added to your ')]")
	public WebElement Message;
		
	@FindBy(xpath = "//span[@title=\"Close\"]")
	public WebElement CloseTab;
		
	public void NoteBook() {
		Notebook.click();
	}
	
	public void SelectProduct() {
		
		Genericutils.Clickonelementusingjavascriptexecutor(SelectMackbook, driver);
		
		//Genericutils.WaitforElement(driver, SelectMackbook, 20);
	}
	public void AdsToCart() {
		Addtocart.click();
	}	
	public void ProductAdded() {
		Message.isDisplayed();
	}
	public void Close() {
		CloseTab.click();
	}

}

