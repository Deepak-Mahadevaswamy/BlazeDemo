package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.blazedemo.base.TestBase;

/**
 * @author Deepak Mahadevaswamy
 *
 */
public class FindFlightsHomePage extends TestBase {

	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement fromAirport;

	@FindBy(xpath = "//select[@name='toPort']")
	WebElement toAirport;

	@FindBy(xpath = "//input[@value='Find Flights']")
	WebElement findFlights;

	
	/**
	 * Constructor - To initialize web elements using PageFactory
	 */
	public FindFlightsHomePage() {
		PageFactory.initElements(driver, this);
	}

	
	/**
	 * Method to select 'From' airport
	 * @param fromairport	 
	 */
	public void selectFromAirport(String fromairport) {

		//Using Explicit Wait here to make sure 'From' dropdown is visible
		Select selectFromAirport = new Select(wait.until(ExpectedConditions.visibilityOf(this.fromAirport)));
		selectFromAirport.selectByVisibleText(fromairport);
	}

	
	/**
	 * Method to select 'To' airport
	 * @param toairport 
	 */
	public void selectToAirport(String toairport) {
		//Using Explicit Wait here to make sure 'To' dropdown is visible
		Select toAirPort = new Select(wait.until(ExpectedConditions.visibilityOf(this.toAirport)));
		toAirPort.selectByVisibleText(toairport);

	}

	
	/**
	 * Method to click on 'Find Flights' button
	 * @return FlightsSearchResultsPage
	 */
	public FlightsSearchResultsPage clickOnFindFlightsBtn() {
		this.findFlights.click();
		return new FlightsSearchResultsPage() ;
	}

}
