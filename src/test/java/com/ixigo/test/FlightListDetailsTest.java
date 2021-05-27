package com.ixigo.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.ixigo.BasseTest;
import com.ixigo.page.BookingPage;

public class FlightListDetailsTest {
 
	public static WebDriver driver;
	
	@BeforeMethod
	public void startup()
	{
		Reporter.log("Launching the URL",true);
		driver = BasseTest.startBrowser("https://www.ixigo.com/");
	}
	@Test
	public void flightDetailsTest() throws InterruptedException
	{
		BookingPage bookpage = new BookingPage(driver);
		Assert.assertEquals("ixigo.com", bookpage.getLogoTitle(),"The page is not loaded");
		bookpage.searchFlight("DEL - New Delhi","BLR - Bengaluru");
		bookpage.filtersetting();
		bookpage.ListAllFlights();
		
	}
	@AfterMethod
	public void tearDown()
	{
		BasseTest.closeBrowser();
	}
}
