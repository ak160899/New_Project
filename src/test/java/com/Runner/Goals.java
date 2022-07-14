package com.Runner;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class Goals extends Base_Class {

	public static WebDriver driver = browserLaunch("chrome");
	static PageObjMan pom = new PageObjMan(driver);

	@Test
	private void Goal() throws IOException, InterruptedException, AWTException {

		driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		implicitWait(50, TimeUnit.SECONDS);

		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());

		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

		Thread.sleep(3000);
		click(pom.getInstanceHealthRec().clickHealthRec);
		click(pom.getInstanceHealthRec().patientRemove);
		implicitWait(30, TimeUnit.SECONDS);
		WebDriverWait wd = new WebDriverWait(driver, 3);
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='patientPartyName'])[6]")));
		WebElement web = driver.findElement(By.xpath("(//input[@id='patientPartyName'])[6]"));
		web.sendKeys("3509501");

		sleep(6000);

		keypress();
		keyenter();

		explicitWait(20, pom.getInstanceHealthRec().clickRecord);

		click(pom.getInstanceHealthRec().clickRecord);

		sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		actions("move to element", pom.getInstanceHealthRec().add);
		explicitWait(30, pom.getInstanceHealthRec().add);
		click(pom.getInstanceHealthRec().add);
		sendkeys(pom.getInstanceHealthRec().discripition, "hello welcome");
		explicitWait(15, pom.getInstanceHealthRec().clickdate);
		click(pom.getInstanceHealthRec().clickdate);
		clear(pom.getInstanceHealthRec().clickdate);
		sendkeys(pom.getInstanceHealthRec().clickdate, "05-22-2021");
		click(pom.getInstanceHealthRec().save);

		click(pom.getInstanceHealthRec().Createfollowup);
		sleep(5000);
		click(pom.getInstanceHealthRec().choosedateFromFollowup);
		sleep(2000);
		dropDown("index", pom.getInstanceHealthRec().month, "2");
		dropDown("value", pom.getInstanceHealthRec().year, "2022");
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[2]/td[5]")).click();

		click(pom.getInstanceHealthRec().fixOppintment);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='9:00am']")).click();
		dropDown("index", pom.getInstanceHealthRec().selectAppintmentType, "2");
		sendkeys(pom.getInstanceHealthRec().enterDiscriptionInappointment, "help im in danger");
		click(pom.getInstanceHealthRec().saveFolloAppointment);
		sleep(2000);
		explicitWait(30, pom.getInstanceHealthRec().deleteFixAppiontment);
		js.executeScript("window.scrollBy(0,0)");

		actions("move to element", pom.getInstanceHealthRec().deleteFixAppiontment);
		sleep(2000);
		click(pom.getInstanceHealthRec().deleteFixAppiontment);
		sleep(3000);
		click(pom.getInstanceHealthRec().cancelAppointment);
		
		quite();
	}
}
