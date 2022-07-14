package com.Runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class SettingRunner extends Base_Class {

	public static WebDriver driver = browserLaunch("chrome");
	static PageObjMan pom = new PageObjMan(driver);

	@Test

	private void settings() throws IOException, InterruptedException {

		driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		implicitWait(50, TimeUnit.SECONDS);

		explicitWait(15, pom.getInstanceLoginPage().sigIn);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());

		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

		try {
			sleep(3000);
		} catch (Exception e) {
		}
   
		click(pom.getInstanceSetting().clickSettings);
		
		
		sleep(2000);
		
		
		
		
		
		  explicitWait(20, pom.getInstanceSetting().scrollTillDelete);
		  
		  ScriptExecutor(pom.getInstanceSetting().scrollTillDelete); sleep(2000);
		  
		  ScriptExecutor(pom.getInstanceSetting().scrollTillTax); sleep(2000);
		  ScriptExecutor(pom.getInstanceSetting().scrollTillHospitalCode); sleep(2000);
		  ScriptExecutor(pom.getInstanceSetting().scrollTillPrintSettings);
		  sleep(2000); ScriptExecutor(pom.getInstanceSetting().scrollTillSubscription);
		  sleep(2000); ScriptExecutor(pom.getInstanceSetting().scrollTillNotification);
		  sleep(2000); ScriptExecutor(pom.getInstanceSetting().scrollTillAuditReport);
		  
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  
		  js.executeScript("window.scroll(0,0)");
		  quite();
		 
	}

}
