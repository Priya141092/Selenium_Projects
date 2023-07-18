package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import main.java.Utility.TestUtil;
import main.java.base.Basecl;

public class HomePage_ShopnewYoga extends Basecl{
	@FindBy(xpath= "//span[@class='action more button']")
	WebElement ShopnewYoga;
	
	@FindBy(id="sorter")
	WebElement sortdropdown;
	

	@FindBy(xpath="(//span[@class='product-image-container']/span/img)[1]")
	WebElement itemselection;
	
	@FindBy(xpath="(//button[@title='Add to Cart'])[1]")
	WebElement FirstItem;
	
	@FindBy(xpath="//*[@class='counter-number' and contains(text(),'1')]")
	public WebElement cartvalue;
	
	
	@FindBy(xpath="//div[@class='column main']//div[2]//div[1]//a[1]")
	WebElement modes;
	
	@FindBy(xpath="//ol[@class='products list items product-items']/li")
	public WebElement allitems;
	
	@FindBy(xpath="//div[@class='block-content filter-content']//div[@role='tablist']//div[1]//div[contains(text(),'Style')]")
	public WebElement firststyle;
	
	
	//div[@role='tablist']//div[1]//div[contains(text(),'Style')]
	
	
	
	/* This class goes to shop yoga stuff and clicks on it */
	
	public HomePage_ShopnewYoga()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickShopnewyoga()
	{
		ShopnewYoga.click();
		
	}
	
	public void count_items_on_page()
	{
		
		
		List<WebElement> p = driver.findElements(By.xpath("//ol[@class='products list items product-items']/li"));
          int tot = p.size();	 
	}
	    
	 public void clickonstyle() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 firststyle.click();
		 Thread.sleep(4000);
		//TestUtil.scrollpagetoclick(firststyle);
		
	 }
	         
	
	
	public void sortByPriceCollection()
	{
		TestUtil.selectiondropdown(sortdropdown, prop.getProperty("sortBy"));
	}
	
	public void modes()
	{
	modes.click();
	}
	
	public void addanitemtocart() throws InterruptedException
	
	{
		
		Thread.sleep(4000);
		TestUtil.scrollpagetoclick(FirstItem);
		
		
		
	}
}
