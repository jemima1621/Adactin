package org.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExecutionPage {
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass base=new BaseClass();
	    WebDriver driver=base.getdriver();
	    base.loadUrl("https://adactin.com/HotelApp/");
	    base.maximize();
	    base.screenshotUserLoc("E:\\Eclipse\\AdactinHotel\\ScreenShot\\BrowserLauch.png");
	    
//Login Page	    
	    LoginPage page=new LoginPage();
	    base.type(page.getTxtUserName(), "jemimaAngel");
	    base.type(page.getTxtPassword(), "QTB8N1");
	    base.btnClick(page.getLoginBtn());
	    base.screenshotUserLoc("E:\\Eclipse\\AdactinHotel\\ScreenShot\\Login.png");
	    
//Search Hotel Page
	    
	    SearchHotelPage page1=new SearchHotelPage();
	    base.dropDownByVisibleText(page1.getLocation(), "Sydney");
	    base.dropDownByVisibleText(page1.getHotels(), "Hotel Sunshine");
	    base.dropDownByVisibleText(page1.getRoomType(), "Double");
	    base.dropDownByVisibleText(page1.getNumOfRooms(), "1 - One"); 
	    base.type(page1.getCheckInDate(), "19/01/2020");
	    base.type(page1.getCheckOutDate(), "20/01/2020");
	    base.dropDownByVisibleText(page1.getAdultCount(), "2 - Two");
	    base.dropDownByVisibleText(page1.getChildrenCount(), "2 - Two");
	    base.btnClick(page1.getSearchBtn());
	    base.screenshotUserLoc("E:\\Eclipse\\AdactinHotel\\ScreenShot\\SearchHotel.png");
	    
//Select Hotel Page
	    
	    SelectHotelPage page2=new SelectHotelPage();
	    base.btnClick(page2.getSelectHotelRdoBtn());
	    base.btnClick(page2.getContinueBtn());
	    base.screenshotUserLoc("E:\\Eclipse\\AdactinHotel\\ScreenShot\\SelectHotel.png");
	    
//Book Hotel Page
	    
	    BookHotelPage page3=new BookHotelPage();
	    base.type(page3.getFirstname(), "Jemima");
	    base.type(page3.getLastname(), "JP");
	    base.type(page3.getBillingAddress(), "73,kumarankudil,mettukupam,chennai-600097");
	    base.type(page3.getCreditCardNum(), "6890245834924596");
	    base.dropDownByVisibleText(page3.getCreditCardType(), "VISA");
	    base.dropDownByVisibleText(page3.getExpMonth(), "March");
	    base.dropDownByVisibleText(page3.getExpYear(), "2022");
	    base.type(page3.getCvvNum(), "6585");
	    base.btnClick(page3.getBookNowBtn());
	    base.screenshotUserLoc("E:\\Eclipse\\AdactinHotel\\ScreenShot\\BookHotel.png");
	    
//Booking Confirmation Page
	    
	    BookingConfirmationPage page4=new BookingConfirmationPage();
	    Thread.sleep(5000);
	    String attribute = base.getAttribute(page4.getOrderNum());
        System.out.println(attribute);
       
	    base.screenshotUserLoc("E:\\Eclipse\\AdactinHotel\\ScreenShot\\BookingConfirmation.png");
	    
	}

}
