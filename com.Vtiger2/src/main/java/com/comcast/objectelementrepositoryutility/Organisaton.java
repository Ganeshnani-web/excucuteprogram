package com.comcast.objectelementrepositoryutility;
/**
 * 
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Organisaton
{

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement  organisationlink;

	public WebElement getOrganisationlink()
	{
		return organisationlink;
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgname;

	public WebElement getOrgname() 
	{
		return orgname;
	}
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industrylist;

	public WebElement getIndustrylist()
	{
		return industrylist;
	}
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	public WebElement getSavebtn() 
	{
		return savebtn;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headertxt;

	public WebElement getHeadertxt()
	{
		return headertxt;
	}
	
	
	
}
