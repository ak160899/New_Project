package com.TestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class Logins extends Base_Class {
	PageObjMan pom;
	WebDriver driver;

	@Test(priority = 1)
	private void chromeLaunch() throws IOException {
		driver = browserLaunch("chrome");
		try {
			geturl(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		} catch (Exception e) {
		}
		pom = new PageObjMan(driver);
		implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

	}

	@Test(priority = 0)
	private void firefoxLaunch() throws IOException {
		driver = browserLaunch("firefox");
		try {
			geturl(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		} catch (Exception e) {
		}
         pom=new PageObjMan(driver);
		implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

	}

}
