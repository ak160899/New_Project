package com.Runner;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;

public class PatientRunner extends Base_Class {
	public static WebDriver driver = browserLaunch("chrome");
	static PageObjMan pom = new PageObjMan(driver);

	private void Patient() throws IOException {
		// TODO Auto-generated method stub

		driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
		explicitWait(30, pom.getInstanceLoginPage().sigIn);

		click(pom.getInstanceLoginPage().sigIn);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());

		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		explicitWait(15, pom.getInstanceLoginPage().login);
		click(pom.getInstanceLoginPage().login);
		implicitWait(30, TimeUnit.SECONDS);
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
		quite();

	}

}
