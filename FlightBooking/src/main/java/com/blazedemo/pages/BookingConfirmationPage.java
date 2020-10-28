package com.blazedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Deepak Mahadevaswamy
 *
 */
public class BookingConfirmationPage {

	@FindBy(xpath="//*[text()='Thank you for your purchase today!']")
	WebElement bookingconfirmationmsg;
	
	@FindBy(xpath="//table[@class='table']/tbody[1]/tr[1]/td[2]")
	WebElement bookingID;
	
	
	/**
	 * Method to validate booking
	 */
	public boolean validateBookingConfirmation(){
		
		String message = this.bookingconfirmationmsg.toString();
		System.out.println("Booking message --> " + message);
		
		String bookingid = this.bookingID.getText();
		System.out.println("Booking ID is --> " + bookingid);
		
		if(bookingid!=null && message!=null)
			return true;
		else 
			return false;
				
	}
	
}
