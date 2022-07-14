package com.Runner;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class BillingRunner extends Base_Class {
	
	public static WebDriver driver = browserLaunch("chrome");
	static PageObjMan pom = new PageObjMan(driver);

	//public static void main(String[] args) throws IOException, InterruptedException {
@Test
private void run() throws IOException, InterruptedException {
	// TODO Auto-generated method stub


		try {
			geturl(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		} catch (Exception e) {
		}
		
		implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);
		
		click(pom.getInstanceBilling().clickBill);
		
		sleep(5000);
		
		explicitWait(15, pom.getInstanceBilling().clickCreateNewBill);
		
		click(pom.getInstanceBilling().clickCreateNewBill);
		
		
		explicitWait(15, pom.getInstanceBilling().addItem);
		click(pom.getInstanceBilling().addItem);
		sendkeys(pom.getInstanceBilling().enterTheItem, "dolo");
		sendkeys(pom.getInstanceBilling().addPrice, "10");
		clear(pom.getInstanceBilling().addQuantity);
		sendkeys(pom.getInstanceBilling().addQuantity, "2");
		sleep(3000);
		click(pom.getInstanceBilling().saveItem);
		quite();
}

//}
}