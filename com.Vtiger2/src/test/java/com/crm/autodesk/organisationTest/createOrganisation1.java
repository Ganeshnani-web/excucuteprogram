package com.crm.autodesk.organisationTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.comcast.objectelementrepositoryutility.Organisaton;
import com.comcast.objectelementrepositoryutility.contact;
import com.comcast.objectelementrepositoryutility.home;
import com.vtiger.genericRepository.Baseclass;
import com.vtiger.genericRepository.DataHandler;
import com.vtiger.genericRepository.Excelorg;
import com.vtiger.genericRepository.WebDrivirUtilit;
import com.vtiger.genericRepository.classutility;


public class createOrganisation1 extends Baseclass

{
	
	@Test
	public void createOrganisation1() throws Exception
	{

		DataHandler d = new DataHandler();
		classutility c = new classutility();
		WebDrivirUtilit u= new WebDrivirUtilit();
		Excelorg e = new Excelorg();
		
	
		String orgname = e.getDataFromExcel("sheet2","Tc_02", "org name") + c.genrateRandomnum();
		String contactname = e.getDataFromExcel("sheet2","Tc_02","contact Name") + c.genrateRandomnum();

		//step 1-naviagate organizations
		home h = PageFactory.initElements(driver,home.class);
		h.getOrganizations().click();
		
		Organisaton o= PageFactory.initElements(driver,Organisaton.class);
		o.getOrganisationlink().click();
		
		//step-2 create organizations
		o.getOrgname().sendKeys(orgname);
		WebElement list = o.getIndustrylist();

		String text="Education";
		u.selectDropDown(text, list);
	
		o.getSavebtn().click();
	 	
		
		//step -3 validation
		String msg = o.getHeadertxt().getText();
		System.out.println(msg);
		
		Assert.assertTrue(msg.contains(orgname));
		
		o.getOrganisationlink().click();
		
		// step-4 navigate to contact
		contact cn = PageFactory.initElements(driver, contact.class);
		cn.getContctlink().click();
		// step -5 navigate to create contact
		cn.getCreatecontc().click();
		 cn.getLastname().sendKeys(contactname);
		
		//step -6 navigate to organizations
		cn.getOggwindow().click();
		
		u.switchToWindow(driver, msg);

		cn.getSearchbtn().sendKeys(orgname);
		cn.getSerch().click();
		cn.getOrgclick().click();
		
		u.switchToWindow(driver, msg);
		
		cn.getSavebtn().click();
		
		//step-7 validation
		String nil= cn.getHeadertxt().getText();
		Assert.assertTrue(nil.contains(contactname));
		
	}
}
