package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webutility.WebdriverUtility;

public class LoginPage  extends WebdriverUtility{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
	
	}
	
	
	@FindBy(name="user_name")
public	WebElement usernameEdt;
	
	@FindBy(name="user_password")
  public WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	public WebElement loginbtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	  //rule 5:provide Action
	public void loginapp(  String url,String username,String password)
	{  
	 WaitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}
		

}
