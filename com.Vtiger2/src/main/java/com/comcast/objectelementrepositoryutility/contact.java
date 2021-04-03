package com.comcast.objectelementrepositoryutility;
/**
 * 
 * @author GABHI
 *
 */



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class contact 
{
	@FindBy(linkText="Contacts")
	private WebElement contctlink;
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontc;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	
	@FindBy(xpath="//select[@name='salutationtype']/option[2][@value='Mr.']")
	private WebElement selectcl;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstnameedit;
	

	@FindBy(css = "#phone")
	private WebElement phoneno;
	
	@FindBy(css="#mobile")
	private WebElement mobileno;
	
	public WebElement getMobileno() 
	{
		return mobileno;
	}

	public WebElement getPhoneno() 
	{
		return phoneno;
	}

	public WebElement getFirstnameedit() 
	{
		return firstnameedit;
	}

	public WebElement getSelectcl()
	{
		return selectcl;
	}

	public WebElement getContctlink() {
		return contctlink;
	}

	public WebElement getCreatecontc() {
		return createcontc;
	}

	public WebElement getLastname() {
		return lastname;
	}
	
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement oggwindow;

	public WebElement getOggwindow()
	{
		return oggwindow;
	}
	@FindBy(id="search_txt")
	private WebElement searchbtn;

	public WebElement getSearchbtn() 
	{
		return searchbtn;
	}
	
	@FindBy(name="search")
	private WebElement serch;

	public WebElement getSerch() 
	{
		return serch;
	}
	
	@FindBy(xpath="//a[contains(text(),'ghgjgh')]")
	private WebElement orgclick;

	public WebElement getOrgclick() 
	{
		return orgclick;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getSavebtn()
	{
		return savebtn;
	}
	
	@FindBys({
		@FindBy(xpath="//a[text()='Taylor']/../../../tr[*]/td[4]")
	})
	private List<WebElement> allcntcs;

	public List<WebElement> getAllcntcs() 
	{
		return allcntcs;
	}
	
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deletebtn;

	public WebElement getDeletebtn() 
	{
		return deletebtn;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headertxt;

	public WebElement getHeadertxt() {
		return headertxt;
	}
	
}
