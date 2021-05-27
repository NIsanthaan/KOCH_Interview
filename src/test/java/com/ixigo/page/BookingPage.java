package com.ixigo.page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import com.ixigo.BasseTest;

public class BookingPage {
    String fromLoc,toLoc;
	@FindBy(xpath="//img[@class='ixigo-logo']") WebElement logo;
	public BookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getLogoTitle()
	{
		return logo.getAttribute("title");
	}
	
	@FindBy(xpath="//div[text()='From']/following-sibling::input") WebElement fromPlace;
	@FindBy(xpath="//div[text()='From']/parent::div/following-sibling::div//div[@class='city'][1]") WebElement fromPlacelist;
	@FindBy(xpath="//div[text()='To']/following-sibling::input") WebElement toPlace;
	@FindBy(xpath="//div[text()='To']/parent::div/following-sibling::div//div[@class='city'][1]") WebElement toPlaceList;
	@FindBy(xpath="//div[text()='Departure']/following-sibling::input") WebElement departureMenu;
	@FindBy(xpath="(//td[@data-date='27062021']/div[text()=27])[1]") WebElement departureDate;
	@FindBy(xpath="//div[text()='Return']/following-sibling::input") WebElement returnMenu;
	@FindBy(xpath="(//td[@data-date='24072021']/div[text()=24])[2]") WebElement returnDate;
	@FindBy(xpath="//div[text()='Travellers | Class']/following-sibling::input") WebElement travellersMenu;
	@FindBy(xpath="//div[text()='Adult']/ancestor::div[@class='number-counter']//span[text()='2']") WebElement AdultTravel;
	@FindBy(xpath="//button[text()='Search']") WebElement searchButton;
	public void searchFlight(String fromLoc, String toLoc) throws InterruptedException {
	    Thread.sleep(1000);
		fromPlace.sendKeys(Keys.CONTROL+"a");
		fromPlace.sendKeys(Keys.CONTROL+"x");
		fromPlace.sendKeys(fromLoc);
		BasseTest.waitForVisibility(fromPlacelist);
		fromPlacelist.click();
		toPlace.sendKeys(toLoc);
		BasseTest.waitForVisibility(toPlaceList);
		toPlaceList.click();
		departureMenu.click();
		BasseTest.waitForVisibility(departureDate);
		departureDate.click();
		returnMenu.click();
		BasseTest.waitForVisibility(returnDate);
		returnDate.click();
		BasseTest.waitForVisibility(travellersMenu);
		travellersMenu.click();
		BasseTest.waitForVisibility(AdultTravel);
		AdultTravel.click();
		searchButton.click();
	}
	@FindBy(xpath="//div[text()='MORE FILTERS']") WebElement filter;
	@FindBy(xpath="//div[text()='AirAsia India']/ancestor::div/span[contains(@class,'checkbox-button')]") WebElement flight_name1;
	@FindBy(xpath="//div[text()='Go Air']/ancestor::div/span[contains(@class,'checkbox-button')]") WebElement flight_name2;
	@FindBy(xpath="//button[text()='06:00 - 12:00']") WebElement timing1;
	@FindBy(xpath="//button[text()='18:00 - 24:00']") WebElement timing2;
	@FindBy(xpath="//button[text()='APPLY']") WebElement applyBT;

	public void filtersetting() throws InterruptedException {
		try{
			BasseTest.elewait().until(ExpectedConditions.visibilityOf(filter));
			Assert.assertTrue(true);	
		}
		catch(TimeoutException e)
		{
			Assert.fail("MoreFilter is not available");
		}
		filter.click();
		flight_name1.click();
		flight_name2.click();
		timing1.click();
		timing2.click();
		applyBT.click();
	
	}
	@FindBy(xpath="//div[@class='result-col outr']//div[contains(@class,'flight-listing')]") List<WebElement> flightdetails1;
	@FindBy(xpath="//div[@class='result-col']//div[contains(@class,'flight-listing')]") List<WebElement> flightdetails2;
	@FindBy(xpath="//div[@class='result-col outr']//div[@class='time-group']//div[@class='airline-text']/div") List<WebElement> flightname_dept1;
	@FindBy(xpath="//div[@class='result-col outr']//div[@class='time-group']//div[@class='time'][1]") List<WebElement> flightstrtime_dept1;
	@FindBy(xpath="//div[@class='result-col outr']//div[@class='time-group']//div[@class='time'][2]") List<WebElement> flightendtime_dept1;
	@FindBy(xpath="//div[@class='result-col']//div[@class='time-group']//div[@class='airline-text']/div") List<WebElement> flightname_dept2;
	@FindBy(xpath="//div[@class='result-col']//div[@class='time-group']//div[@class='time'][1]") List<WebElement> flightstrtime_dept2;
	@FindBy(xpath="//div[@class='result-col']//div[@class='time-group']//div[@class='time'][2]") List<WebElement> flightendtime_dept2;
	public void ListAllFlights() {
		System.out.println("The number of flights for departure is "+flightdetails1.size());
		for(int i=0;i<flightdetails1.size();i++)
		{
			String flightname=flightname_dept1.get(i).getText().trim();
			String flightstrtime = flightstrtime_dept1.get(i).getText();
			String flightendtime = flightendtime_dept1.get(i).getText();
			System.out.println(flightname+" flight is available for the timing "+flightstrtime+" -> "+flightendtime+" in departure");
		}
		System.out.println("The number of flights for return is "+flightdetails2.size());
		for(int i=0;i<flightdetails2.size();i++)
		{
			String flightname=flightname_dept2.get(i).getText().trim();
			String flightstrtime = flightstrtime_dept2.get(i).getText();
			String flightendtime = flightendtime_dept2.get(i).getText();
			System.out.println(flightname+" flight is available for the timing "+flightstrtime+" -> "+flightendtime+" in Return");
		}
	}
}
