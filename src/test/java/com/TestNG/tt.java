package com.TestNG;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class tt extends Base_Class {
	public static WebDriver driver;
	static PageObjMan pom;

	@BeforeClass
	private void launchBrowser() throws IOException, InterruptedException {

		driver = browserLaunch("chrome");
		pom = new PageObjMan(driver);

		try {
			geturl(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		} catch (Exception e) {
		}

		implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		// explicitWait(15, pom.getInstanceLoginPage().login);
		click(pom.getInstanceLoginPage().login);

		sleep(3000);
	}

	@Test(priority = 1)
	private void pateientCreation() throws InterruptedException {

		click(pom.getInstanceNewPatient().addPatient);
		sendkeys(pom.getInstanceNewPatient().firstName, "sam");
		sendkeys(pom.getInstanceNewPatient().lastname, "n");
		click(pom.getInstanceNewPatient().clickGenderIcon);

		List<WebElement> genders = driver.findElements(By.xpath("(//ul[@id='genderDropdown'])[1]/li"));
		for (WebElement opt : genders) {

			if (opt.getText().equals("Male")) {

				driver.findElement(By.xpath("(//ul[@id='genderDropdown'])[1]/li")).click();

			}
			break;
		}

		click(pom.getInstanceNewPatient().CreatePatient);

		click(pom.getInstanceNewPatient().addContact);
		sendkeys(pom.getInstanceNewPatient().addAddress, "24 usa los angles");
		sendkeys(pom.getInstanceNewPatient().addCity, "chennai");
		explicitWait(30, pom.getInstanceNewPatient().selectCountry);

		dropDown("text", pom.getInstanceNewPatient().selectCountry, "India");
		// dropDown("value", pom.getInstanceNewPatient().selectState, "Tamilnadu");
		sendkeys(pom.getInstanceNewPatient().zipCode, "600110");

		click(pom.getInstanceNewPatient().saveContact);
		sleep(3000);

	}

	@Test(priority = 2)
	private void healthRecord() throws InterruptedException, AWTException {
		implicitWait(40, TimeUnit.SECONDS);
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
		explicitWait(40, pom.getInstanceHealthRec().add);
		sleep(4000);
		click(pom.getInstanceHealthRec().add);
		sendkeys(pom.getInstanceHealthRec().discripition, "hello welcome");
		explicitWait(30, pom.getInstanceHealthRec().clickdate);
		sleep(3000);
		click(pom.getInstanceHealthRec().clickdate);
		clear(pom.getInstanceHealthRec().clickdate);
		sendkeys(pom.getInstanceHealthRec().clickdate, "05-22-2021");
		sleep(3000);
		explicitWait(15, pom.getInstanceHealthRec().save);

		click(pom.getInstanceHealthRec().save);
		sleep(2000);
		click(pom.getInstanceHealthRec().Createfollowup);
		sleep(3000);
		// driver.findElement(By.id("dp1657692799776")).clear();
		// sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']")).sendKeys("10-15-2022");
		// driver.findElement(By.id("dp1657692799776")).sendKeys("10-14-2022");
		// click(pom.getInstanceHealthRec().choosedateFromFollowup);
		sleep(3000);
		/*
		 * dropDown("index", pom.getInstanceHealthRec().month, "2"); dropDown("value",
		 * pom.getInstanceHealthRec().year, "2022");
		 * 
		 * //driver.findElement(By.xpath(
		 * "//div[@id='ui-datepicker-div']/table/tbody/tr[2]/td[5]")).click();
		 */
		click(pom.getInstanceHealthRec().fixOppintment);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='9:00am']")).click();
		dropDown("index", pom.getInstanceHealthRec().selectAppintmentType, "2");
		sendkeys(pom.getInstanceHealthRec().enterDiscriptionInappointment, "help im in danger");
		sleep(2000);
		explicitWait(30, pom.getInstanceHealthRec().saveFolloAppointment);
		click(pom.getInstanceHealthRec().saveFolloAppointment);
		// ScriptExecutor()
		sleep(3000);
		// driver.findElement(By.xpath("(//div[text()='Save'])[13]")).click();
		// sleep(2000);
		explicitWait(30, pom.getInstanceHealthRec().deleteFixAppiontment);
		js.executeScript("window.scrollBy(0,0)");

		actions("move to element", pom.getInstanceHealthRec().deleteFixAppiontment);
		sleep(2000);
		click(pom.getInstanceHealthRec().deleteFixAppiontment);
		sleep(3000);
		click(pom.getInstanceHealthRec().cancelAppointment);

		sleep(3000);

	}

	@Test(priority = 3)
	private void calendar() throws AWTException, InterruptedException, IOException {

		sleep(2000);
		implicitWait(30, TimeUnit.SECONDS);
		explicitWait(20, pom.getInstanceCalendar().clickCalendar);
		sleep(3000); //
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

					// driver.findElement(By.xpath("(//div[@title='Click to book
					// appointment'])[1]")).click();
					sleep(3000);
            // click(click);
		implicitWait(30, TimeUnit.SECONDS);
		sleep(3000); //
		driver.findElement(By.id("AppointmentPatientName")).sendKeys("t");
		sleep(3000);
		keypress();
		keyenter();
		dropDown("index", pom.getInstanceCalendar().selectAppointmentType, "1");
		sleep(5000);

		driver.findElement(By.xpath("(//textarea[@id='description'])[4]")).sendKeys("chill and cough.."); // //
		sendkeys(pom.getInstanceCalendar().enterDiscription, "fever and cold"); //
		implicitWait(30, TimeUnit.SECONDS); // sleep(2000); //
		ScriptExecutor(pom.getInstanceCalendar().saveAppointment);
		sleep(2000);
		click(pom.getInstanceCalendar().saveAppointment);

		sleep(4000);
	}

	@Test(priority = 4)
	private void billing() throws InterruptedException {
		explicitWait(15, pom.getInstanceBilling().clickBill); //
		click(pom.getInstanceBilling().clickBill);
		sleep(5000);
		explicitWait(15, pom.getInstanceBilling().clickCreateNewBill);
		click(pom.getInstanceBilling().clickCreateNewBill);
		explicitWait(30, pom.getInstanceBilling().addItem);
		sleep(3000);
		click(pom.getInstanceBilling().addItem);
		sendkeys(pom.getInstanceBilling().enterTheItem, "dolo"); //
		sendkeys(pom.getInstanceBilling().addPrice, "10"); //
		clear(pom.getInstanceBilling().addQuantity); //
		sendkeys(pom.getInstanceBilling().addQuantity, "2");
		sleep(3000);
		click(pom.getInstanceBilling().saveItem);
	}

	@Test(priority = 5)
	private void teleDoctor() throws AWTException, InterruptedException { //
		explicitWait(30, pom.getInstanceTeleDoctor().clickTeleDoctor); //
		sleep(5000);
		click(pom.getInstanceTeleDoctor().clickTeleDoctor); //
		sleep(3000);
		sendkeys(pom.getInstanceTeleDoctor().searchDoctor, "3368683");
		sleep(3000);
		explicitWait(20, pom.getInstanceTeleDoctor().searchDoctor);
		keypress();
		keyenter();
		sleep(3000);
		sendkeys(pom.getInstanceTeleDoctor().searchPatient, "3355166");
		explicitWait(25, pom.getInstanceTeleDoctor().searchPatient);
		sleep(3000);
		keypress();
		keyenter();
		sleep(5000);
		// explicitWait(15, );
		driver.findElement(By.xpath("(//div[@title='Click to view'])[4]")).click();
		// // click(pom.getInstanceTeleDoctor().clickPatient); // // quite(); //
		sleep(3000);
	}

	@Test(priority = 6)
	private void message() throws InterruptedException, AWTException {
		explicitWait(30, pom.getInstanceMessage().clickMessage);
		sleep(5000); //
		click(pom.getInstanceMessage().clickMessage);
		sleep(5000); //
		explicitWait(20, pom.getInstanceMessage().clickComposemMessage); // //
		click(pom.getInstanceMessage().clickComposemMessage); //
		sendkeys(pom.getInstanceMessage().search, "3509501");
		sleep(2000); //
		keypress();
		keyenter(); //
		sendkeys(pom.getInstanceMessage().enterSubject, "GOOD MORNING"); //
		sendkeys(pom.getInstanceMessage().enterMessage, "hello welcome to chennai");
		click(pom.getInstanceMessage().sendMessage);
		sleep(3000); //
		click(pom.getInstanceMessage().seeSentMessage);
		sleep(3000);
	}

	@Test(priority = 7)
	private void setting() throws InterruptedException {
		explicitWait(50, pom.getInstanceSetting().clickSettings);
		sleep(9000);
		click(pom.getInstanceSetting().clickSettings);
		sleep(2000);
		explicitWait(40, pom.getInstanceSetting().scrollTillDelete);
		ScriptExecutor(pom.getInstanceSetting().scrollTillDelete);
		sleep(2000);
		ScriptExecutor(pom.getInstanceSetting().scrollTillTax);
		sleep(2000);
		ScriptExecutor(pom.getInstanceSetting().scrollTillHospitalCode);
		sleep(2000); //
		ScriptExecutor(pom.getInstanceSetting().scrollTillPrintSettings); //
		sleep(2000); //
		ScriptExecutor(pom.getInstanceSetting().scrollTillSubscription); //
		sleep(2000); //
		ScriptExecutor(pom.getInstanceSetting().scrollTillNotification); //
		sleep(2000); //
		ScriptExecutor(pom.getInstanceSetting().scrollTillAuditReport); // //
		JavascriptExecutor js = (JavascriptExecutor) driver; // //
		js.executeScript("window.scroll(0,0)");
	}

}
