package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webutility.WebdriverUtility;

public class CreatingNewOrganizationPage {

	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	
	}
	
	
	@FindBy(name="accountname")
	 private WebElement orgNameEdtBtn;
	
	
	public WebElement getIndustryBD() {
		return industryBD;
	}


	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	@FindBy(name="industry")
	private WebElement industryBD;
	
	@FindBy(name="accounttype")
	private WebElement TypeDD;
	
	@FindBy(id="phone")
   private WebElement phonelink;

	public WebElement getPhonelink() {
		return phonelink;
	}


	public WebElement getOrgNameEdt() {
		return orgNameEdtBtn;
	}


	public WebElement getTypeDD() {
		return TypeDD;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void createOrg(String orgName)
	{
		orgNameEdtBtn.sendKeys(orgName);
		SaveBtn.click();
		
	}
	
	public void createphone(String phoneNumber)
	{
		phonelink.sendKeys(phoneNumber);
		SaveBtn.click();
		
	}
	
	public void createOrgWithPhone(String orgName ,String phoneNumber)
	{ 
		orgNameEdtBtn.sendKeys(orgName);
		phonelink.sendKeys(phoneNumber);
		SaveBtn.click();
		
	}
	
	
	public void createOrg(String orgName,String industry, String Type)
	{
		orgNameEdtBtn.sendKeys(orgName);
		WebdriverUtility wlib = new WebdriverUtility();
		wlib.select(industryBD, industry);
		wlib.select(TypeDD, Type);
		SaveBtn.click();
	}

}
