package com.Runner;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class MessageRuner extends Base_Class {

	public static WebDriver driver = browserLaunch("chrome");
	static PageObjMan pom = new PageObjMan(driver);

	@Test
	private void Message() throws IOException, AWTException, InterruptedException {

		geturl(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		explicitWait(30, pom.getInstanceLoginPage().sigIn);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		sleep(2000);
		click(pom.getInstanceLoginPage().login);
		explicitWait(30, pom.getInstanceMessage().clickMessage);
		click(pom.getInstanceMessage().clickMessage);
sleep(5000);
		explicitWait(20, pom.getInstanceMessage().clickComposemMessage);

		click(pom.getInstanceMessage().clickComposemMessage);
		sendkeys(pom.getInstanceMessage().search, "3509501");

		sleep(2000);

		keypress();
		keyenter();
		sendkeys(pom.getInstanceMessage().enterSubject, "GOOD MORNING");
		sendkeys(pom.getInstanceMessage().enterMessage, "hello welcome to chennai");
		click(pom.getInstanceMessage().sendMessage);
		sleep(3000);
		click(pom.getInstanceMessage().seeSentMessage);
		quite();

	}

}
