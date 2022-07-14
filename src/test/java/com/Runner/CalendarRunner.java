package com.Runner;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class CalendarRunner extends Base_Class {

	public static WebDriver driver = browserLaunch("chrome");
	static PageObjMan pom = new PageObjMan(driver);

	@Test
	private void Calendar() throws AWTException, IOException, InterruptedException {

		implicitWait(30, TimeUnit.SECONDS);
		try {
			geturl(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		} catch (Exception e) {
		}
		explicitWait(15, pom.getInstanceLoginPage().sigIn);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

		click(pom.getInstanceCalendar().clickCalendar);

		sleep(5000);
		driver.findElement(By.xpath("(//button[@id='calendar-day-month'])[1]")).click();
		sleep(2000);

		List<WebElement> choose = driver.findElements(By.xpath("//ul[@id='calendarul']/li"));
		for (WebElement web : choose) {
			if (web.getText().equals("Today")) {
				driver.findElement(By.xpath("//ul[@id='calendarul']/li")).click();
				break;
			}
		}

		sleep(4000);
		driver.findElement(By.xpath("(//div[@title='Click to book appointment'])[1]")).click();
		implicitWait(30, TimeUnit.SECONDS);
		sleep(3000);
		driver.findElement(By.id("AppointmentPatientName")).sendKeys("t");

		sleep(3000);

		keypress();
		keyenter();

		dropDown("index", pom.getInstanceCalendar().selectAppointmentType, "1");
		sleep(3000);
		driver.findElement(By.xpath("(//textarea[@id='description'])[1]")).sendKeys("chill and cough..");
		// sendkeys(pom.getInstanceCalendar().enterDiscription, "fever and cold");
		click(pom.getInstanceCalendar().saveAppointment);
		sleep(5000);
WebDriverWait wait=new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='val'])[15]"))).click();

		driver.findElement(By.xpath("(//div[@id='val'])[15]")).click();
//		  click(pom.getInstanceCalendar().clickonBookedAppointment); sleep(3000);
		sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@id='del-btn'])[3]"))).click();
		  ScriptExecutor(pom.getInstanceCalendar().deleteSchedule);
		  
		  click(pom.getInstanceCalendar().deleteSchedule); sleep(2000);
		  driver.findElement(By.id("yes-btn")).click();
		 // click(pom.getInstanceCalendar().yes); // quite();
		 sleep(4000);
		// driver.findElement(By.xpath("(//span[@id='del-btn'])[3]")).click()
;
		 sleep(3000);
		// driver.findElement(By.xpath("(//span[@ID='yes-btn'])[4]")).click();
		 
	}

}
