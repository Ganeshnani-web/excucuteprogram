package com.comcast.objectelementrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class home 
{
	
	@FindBy(linkText="Organizations")
	private WebElement Organizations;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;

	public WebElement getOrganizations() {
		return Organizations;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

}
