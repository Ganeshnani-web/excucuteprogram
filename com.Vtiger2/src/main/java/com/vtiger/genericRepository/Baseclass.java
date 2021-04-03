package com.vtiger.genericRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.objectelementrepositoryutility.Login;
import com.comcast.objectelementrepositoryutility.home;

public class Baseclass 
{
	protected  WebDriver  driver;
	DataHandler dh= new DataHandler();
	DataBaseUtilities dlip = new DataBaseUtilities();

	@BeforeSuite
	public void confiBS()
	{
		System.out.println("=============connect DB======================");
		dlip.connectToDB();
	}
	
	
	@BeforeClass
	public void confiBC() throws Exception
	{
		System.out.println("launch browser successfully");
		
		if (dh.getPropertykeyValue("browser").equals("chrome")) 
		{
			
			driver = new ChromeDriver();
		}
		else if (dh.getPropertykeyValue("browser").equals("firefox")) 
		{
		
			driver = new FirefoxDriver();
		} else
		{
			
			driver = new OperaDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	 
	@BeforeMethod
	public void confiBM() throws Exception
	{
		System.out.println("login starts");
		
		driver.get(dh.getPropertykeyValue("url"));
		
		Login lp=PageFactory.initElements(driver, Login.class);
		
		lp.LoginToApp();
	}
	@AfterMethod
	public void confiAM()
	{
		
		System.out.println("logout succes");
		home h =PageFactory.initElements(driver, home.class);
		
		Actions a = new Actions(driver);
		a.moveToElement(h.getSignout()).perform();
		h.getSignoutbtn();
		
	}
	@AfterClass
	public void confiAC()
	{
		
		driver.close();
	}
	
	@AfterSuite
	public void confiAS() throws SQLException
	{
		System.out.println("===========close DB=====================");
		dlip.closeDb();
	}
	
}
