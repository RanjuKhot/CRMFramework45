package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
  @FindBy(name="lastname")
   private  WebElement LastNameEdtBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public WebElement getLastNameEdtBtn() {
		return LastNameEdtBtn;
	}
	@FindBy(name="search")
	private WebElement searchbutton;

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getSearchTextBox() {
		return SearchTextBox;
	}
	@FindBy(name="search_text")
	private WebElement SearchTextBox;
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	


	public void createlastname(String LastName)
	{
		LastNameEdtBtn.sendKeys(LastName);
		SaveBtn.click();
		
	}
	
	@FindBy(name="support_start_date")
	private WebElement StartDateBtn;
	
	
	@FindBy(name="support_end_date")
	private WebElement EndDateBtn;
	
	public WebElement getStartDateBtn() {
		return StartDateBtn;
	}

	public WebElement getEndDateBtn() {
		return EndDateBtn;
	}
	
	public void createstartdate(String startdate)
	{
	StartDateBtn.sendKeys(startdate);
	SaveBtn.click();
	}
	
	public void createenddate(String enddate)
	{
	StartDateBtn.sendKeys(enddate);
	SaveBtn.click();
	}
	
	public void Createcontact( String  LastName,String startdate,String enddate )
	{
		LastNameEdtBtn.sendKeys(LastName);
		StartDateBtn.clear();
		StartDateBtn.sendKeys(startdate);
		EndDateBtn.clear();
		EndDateBtn.sendKeys(enddate);
		SaveBtn.click();
	}
	
}


