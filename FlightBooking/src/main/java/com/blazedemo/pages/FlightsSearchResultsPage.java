package com.blazedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.blazedemo.base.TestBase;

/**
 * @author Deepak Mahadevaswamy
 *
 */
public class FlightsSearchResultsPage extends TestBase {

	@FindBy(xpath = "//table[@class='table']/tbody/tr")
	WebElement searchResultsTable;

	@FindBy(xpath = "//table[@class='table']/tbody/tr[1]//input[@value='Choose This Flight']")
	WebElement chhoseTheFlightBtn;

	@FindBy(xpath = "//input[@name='price']")
	WebElement priceColumnList;

	/**
	 * Method to choose the flight with minimum price
	 * @return PassengerDetailsPage
	 */
	public PassengerDetailsPage chooseTheFlightWithMinimumPrice() {

		double minPrice = 0.0;
		int index = 1;
		String min;
		
		List<WebElement> we = driver.findElements(By.xpath("//input[@name='price']"));			
		
		//Get the first element price to compare
		String firstPrice = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/input[@name='price']"))
				.getAttribute("value");
		
		minPrice = Double.parseDouble(firstPrice);
				System.out.println("Price of element 1is --> " + minPrice);	

		//Compare the first element price with other prices to pick the minimum price value flight
		for (int i = 2; i <= we.size(); i++) {

			min = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + i + "]/input[@name='price']"))
					.getAttribute("value");
			System.out.println("Price of element " + i + "is --> " + min);

			if (Double.parseDouble(min) < minPrice){
				minPrice = Double.parseDouble(min);
				index = i;
			}

		}

		//Click on the lowest price flight
		driver.findElement(
				By.xpath("//table[@class='table']/tbody/tr[" + index + "]//input[@value='Choose This Flight']"))
				.click();

		System.out.println("Flight with minimum price has been selected --> " + minPrice);
		return new PassengerDetailsPage();

	}

}
