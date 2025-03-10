package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;
	public ContactInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(xpath="//span[@id='dtlview_Support Start Date']")
	private WebElement headerStartDateInfo;
	
	@FindBy(xpath="//span[@id='dtlview_Support End Date']")
	private WebElement headrerEndDateInfo;
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getHeaderStartDateInfo() {
		return headerStartDateInfo;
	}

	public WebElement getHeadrerEndDateInfo() {
		return headrerEndDateInfo;
	}
	}