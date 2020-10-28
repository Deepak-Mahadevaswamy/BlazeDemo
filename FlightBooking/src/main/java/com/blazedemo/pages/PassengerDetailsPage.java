package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.blazedemo.base.TestBase;

/**
 * @author Deepak Mahadevaswamy
 *
 */
public class PassengerDetailsPage extends TestBase {

	@FindBy(xpath = "//input[@name='inputName']")
	WebElement name;

	@FindBy(xpath = "//input[@id='address']")
	WebElement address;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//input[@id='state']")
	WebElement state;

	@FindBy(xpath = "//input[@id='zipCode']")
	WebElement zipcode;

	@FindBy(xpath = "//select[@id='cardType']")
	WebElement cardtype;

	@FindBy(xpath = "//input[@id='creditCardNumber']")
	WebElement cardnumber;

	@FindBy(xpath = "//input[@id='creditCardMonth']")
	WebElement expirymonth;

	@FindBy(xpath = "//input[@id='creditCardYear']")
	WebElement expiryyear;

	@FindBy(xpath = "//input[@id='nameOnCard']")
	WebElement nameoncard;

	@FindBy(xpath = "//input[@value='Purchase Flight']")
	WebElement purchaseflightbtn;

	/**
	 * Method to add passenger details
	 * 
	 * @throws InterruptedException
	 */
	public void addPassengerDetails() throws InterruptedException {

		this.name.sendKeys(prop.getProperty("name"));
		this.address.sendKeys(prop.getProperty("address"));
		this.city.sendKeys(prop.getProperty("city"));
		this.state.sendKeys(prop.getProperty("state"));
		this.zipcode.sendKeys(prop.getProperty("zipcode"));
		this.cardnumber.sendKeys(prop.getProperty("cardnumber"));
		this.expirymonth.sendKeys(prop.getProperty("expirymonth"));
		this.expiryyear.sendKeys(prop.getProperty("expiryyear"));
		this.nameoncard.sendKeys(prop.getProperty("nameoncard"));

		Select cardType = new Select(wait.until(ExpectedConditions.visibilityOf(this.cardtype)));
		cardType.selectByValue(prop.getProperty("cardtype"));
	}

	/**
	 * Method to click on PurchaseFlight button
	 * 
	 * @return BookingConfirmationPage
	 */
	public BookingConfirmationPage clickOnPurchaseFlight() {
		this.purchaseflightbtn.click();
		return new BookingConfirmationPage();
	}

}
