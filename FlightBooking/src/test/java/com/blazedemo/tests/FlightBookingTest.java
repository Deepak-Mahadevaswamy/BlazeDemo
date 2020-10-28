package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.base.TestBase;
import com.blazedemo.pages.FindFlightsHomePage;
import com.blazedemo.pages.BookingConfirmationPage;
import com.blazedemo.pages.FlightsSearchResultsPage;
import com.blazedemo.pages.PassengerDetailsPage;

/**
 * @author Deepak Mahadevaswamy
 *
 */
public class FlightBookingTest extends TestBase {

	FindFlightsHomePage flightsHomePage;
	BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
	FlightsSearchResultsPage flightSearchResultsPage = new FlightsSearchResultsPage();
	PassengerDetailsPage passengerDetailsPage = new PassengerDetailsPage();

	public FlightBookingTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		flightsHomePage = new FindFlightsHomePage();
	}

	@Test
	public void FlightBookingValidTest() throws InterruptedException {

		flightsHomePage.selectFromAirport(prop.getProperty("fromairport"));

		flightsHomePage.selectToAirport(prop.getProperty("toairport"));

		flightSearchResultsPage = flightsHomePage.clickOnFindFlightsBtn();

		passengerDetailsPage = flightSearchResultsPage.chooseTheFlightWithMinimumPrice();

		passengerDetailsPage.addPassengerDetails();

		bookingConfirmationPage = passengerDetailsPage.clickOnPurchaseFlight();

		Assert.assertTrue(bookingConfirmationPage.validateBookingConfirmation());

	}

	@AfterMethod
	public void cleanUp() {
		tearDown();
	}

}
