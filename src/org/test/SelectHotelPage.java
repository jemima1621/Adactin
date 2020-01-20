package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement selectHotelRdoBtn;
	
	@FindBy(id="continue")
	private WebElement continueBtn;

	public WebElement getSelectHotelRdoBtn() {
		return selectHotelRdoBtn;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}
	

}
