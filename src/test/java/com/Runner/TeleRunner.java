package com.Runner;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class TeleRunner extends Base_Class {
	public static WebDriver driver = browserLaunch("chrome");
	static PageObjMan pom = new PageObjMan(driver);

	@Test
	public void start() throws AWTException, IOException, InterruptedException {
		
		geturl(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		explicitWait(30, pom.getInstanceLoginPage().sigIn);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email, ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		try{sleep(2000);}catch(Exception e) {}
		click(pom.getInstanceLoginPage().login);
		explicitWait(30, pom.getInstanceTeleDoctor().clickTeleDoctor);
		click(pom.getInstanceTeleDoctor().clickTeleDoctor);
		sendkeys(pom.getInstanceTeleDoctor().searchDoctor, "3368683");
		explicitWait(20, pom.getInstanceTeleDoctor().searchDoctor);
		keypress();
		keyenter();
		sleep(3000);
		sendkeys(pom.getInstanceTeleDoctor().searchPatient, "3355166");
		explicitWait(20, pom.getInstanceTeleDoctor().searchPatient);
	       sleep(3000);
		keypress();
		keyenter();
		
		sleep(3000);
		//explicitWait(15, );
		driver.findElement(By.xpath("(//div[@title='Click to view'])[4]")).click();
	//	click(pom.getInstanceTeleDoctor().clickPatient);
		//quite();
		

	}

}
