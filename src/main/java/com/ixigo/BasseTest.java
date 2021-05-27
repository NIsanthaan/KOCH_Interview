package com.ixigo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasseTest {
 public static WebDriver driver;
 
 public static WebDriver startBrowser(String URL)
 {
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	 driver.manage().deleteAllCookies();
	 driver.get(URL);
	 return driver;
 }
 public static WebDriverWait  elewait(){
	 return new WebDriverWait(driver,120);
 }
 public static void waitForVisibility(WebElement element) {
	  new WebDriverWait(driver, 60)
     .until(ExpectedConditions.visibilityOf(element));
	
}
public static void closeBrowser() {
	driver.close();
	// TODO Auto-generated method stub
	
}

 
}
