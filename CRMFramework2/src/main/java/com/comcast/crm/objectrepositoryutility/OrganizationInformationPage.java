package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	
	}
	
	public WebElement getHeaderInduMsg() {
		return headerInduMsg;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
  
	@FindBy(xpath="//span[@id='dtlview_Type']")
	private WebElement headerTypeMsg;
	
	@FindBy(xpath="//span[@id='dtlview_Phone']")
	private WebElement hearderphmsg;
	
	public WebElement getHeaderTypeMsg() {
		return headerTypeMsg;
	}

	public WebElement getHearderphmsg() {
		return hearderphmsg;
	}

	
	@FindBy(xpath="//option[@value='Energy']")
	private WebElement headerInduMsg;
}



