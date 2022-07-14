package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Billing {
	
	public WebDriver driver;
	
	@FindBy (xpath = "//td[text()='Billing']")
	public WebElement clickBill;
	
	@FindBy(xpath = "//button[@title='Create new Bill']")
	public WebElement clickCreateNewBill;
	
	@FindBy(xpath = "(//button[@id='add-btn'])[25]")
	public WebElement addItem;
	
	@FindBy(xpath = "(//input[@id='description'])[3]")
	public WebElement enterTheItem;
	
	@FindBy(xpath = "(//input[@id='price'])[2]")
	public WebElement addPrice;
	
	@FindBy(xpath = "(//input[@id='quantity'])[3]")
	public WebElement addQuantity;
	
	@FindBy(xpath = "(//button[@title='Save item'])[3]")
	public WebElement saveItem;
	
	@FindBy(xpath = "(//button[@id='cancel-btn'])[12]")
	public WebElement cancelItem;
	
	@FindBy(xpath = "(//input[@id='search-string'])[2]")
	public WebElement FavoriteItem;
	
	@FindBy(xpath = "(//div[@class='col-xs-1 center-cont hover'])[14]")
	public WebElement addThisToFavorite;
	
	@FindBy(xpath = "//button[@id='finalize-bill']")
	public WebElement finaliseBill;
	
	@FindBy(xpath = "(//button[@id='print'])[6]")
	public WebElement printBill;
	
	@FindBy(xpath = "(//button[@id='del'])")
	public WebElement deleteBill;
	
	@FindBy(xpath = "(//button[@id='back'])[1]")
	public WebElement goBack;
	
	@FindBy(xpath = "(//button[@id='accept-btn'])[21]")
	public WebElement confirmFinalise;
	
	@FindBy(xpath = "(//button[@id='cancel-btn'])[20]")
	public WebElement cancelBill;
	
	public Billing(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
