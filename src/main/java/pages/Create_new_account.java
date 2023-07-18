package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utility.TestUtil;
import main.java.base.Basecl;

public class Create_new_account extends Basecl{

	@FindBy(xpath="//a[text()='Create an Account']")
	WebElement clickoncreateaccount;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lname;
	
	
	@FindBy(xpath = "//input[@id='email_address']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement npass;
	
	@FindBy(xpath = "//input[@id='password-confirmation']")
	WebElement cpass;
	

	@FindBy(xpath = "//button[@title='Create an Account']")
	WebElement createacc;
	
	
	/* This class creates new account and add data through EXCEL and use of apache POI */
	
	public Create_new_account()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Clickoncreateaccount()
	{
		clickoncreateaccount.click();
	}
	
	public void fillalldetails(String FirstName, String LastName,String Email, String Newpass, String Cnfpass)
	{
		fname.sendKeys(FirstName);
		lname.sendKeys(LastName);
		email.sendKeys(Email);
		npass.sendKeys(Newpass);
		cpass.sendKeys(Cnfpass);
		createacc.click();
		
		
		
	}
	
	

}
