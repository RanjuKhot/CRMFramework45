package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	
	}
	
    @FindBy(xpath="//img[@title='Create Organization...']")
    private WebElement createNewOrgBtn;
    
    @FindBy(name="search_text")
    private WebElement SearchTxtBox;
    
    @FindBy(name="search_field")
    private WebElement SearchDropDown;
    
    @FindBy(name="submit")
    private WebElement SearchBtn;
    
    
	public WebElement getSearchBtn() {
		return SearchBtn;
	}


	public WebElement getSearchTxtBox() {
		return SearchTxtBox;
	}


	public WebElement getSearchDropDown() {
		return SearchDropDown;
	}


	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	

}
