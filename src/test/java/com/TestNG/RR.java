package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RR {
	

WebDriver driver;
@BeforeTest
public void  chromelaunch (){
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
  driver = new ChromeDriver();
 driver.get("https://www.75health.com/login.jsp");
 driver.manage().window().maximize();
}
 
 @Test
  public void test() throws Exception {
 

 
  driver.findElement(By.xpath("//span[contains(@onclick,'login.resetPassword()')]")).click();
 
  driver.findElement(By.xpath("//input[@id='userLoginId']")).sendKeys("vigneshmallaia@gmail.com");

  driver.findElement(By.xpath("//button[contains(@id,'getpassword')]")).click();
 // WebElement button = driver.findElement(By.xpath("(//button[contains(@class,'icon-color btn btn-default')])[3]"));
  Thread.sleep(5000);
  driver.findElement(By.xpath("//button[text()='OK']")).click();
 
 
 
 


  }
 @AfterTest
 public void close2() {



 driver.close();

 }

}
