package com.comcast.objectelementrepositoryutility;
/**
 * 
 * @author GABHI
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
//	public Login(WebDriver driver)
//	{
//		PageFactory.initElements(driver, this);
//	}
//	
	
	
//	@FindBy(name="user_name")
//	public WebElement usernameEdit1;
	
	
	@FindAll({@FindBy(id="userid"),@FindBy(name="user_name")})
	private WebElement usernaemEdit1;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement clickbtn;

	public WebElement getUsernaemEdit1() {
		return usernaemEdit1;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getClickbtn() {
		return clickbtn;
	}
	public void  LoginToApp()
	{
		usernaemEdit1.sendKeys("admin");
		passwordEdit.sendKeys("root");
		clickbtn.click();
	}
	public void loginToApp(String username,String password)
	{
		usernaemEdit1.sendKeys(username);
		passwordEdit.sendKeys(password);
		clickbtn.click();
	}
}
