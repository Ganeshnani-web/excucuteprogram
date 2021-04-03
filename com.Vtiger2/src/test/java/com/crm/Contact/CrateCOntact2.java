package com.crm.Contact;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.objectelementrepositoryutility.contact;
import com.vtiger.genericRepository.Baseclass;
import com.vtiger.genericRepository.DataHandler;
import com.vtiger.genericRepository.Excelorg;
import com.vtiger.genericRepository.classutility;

public class CrateCOntact2 extends Baseclass
{
	
	@Test
	public void CrateCOntact() throws Exception
	{
		DataHandler d = new DataHandler();
		classutility c = new classutility();
		Excelorg e = new Excelorg();
		
		String cont1 = e.getDataFromExcel("sheet2", "Tc_01", "contact Name") + c.genrateRandomnum();
		String contactname = e.getDataFromExcel("sheet2", "Tc_03", "contact Name") + c.genrateRandomnum();
		String mobileno = e.getDataFromExcel("sheet2","Tc_04","contact Name");
		String phoneno = e.getDataFromExcel("sheet2","Tc_05","contact Name");
		

		/*step-1 navigate to Contacts */
		
		contact co = PageFactory.initElements(driver,contact.class);
		co.getContctlink().click();
		co.getCreatecontc().click();
		
		// step-2 create contact

		co.getSelectcl().click();
		co.getFirstnameedit().sendKeys(cont1);
		co.getLastname().sendKeys(contactname);
		co.getPhoneno().sendKeys(phoneno);
		co.getMobileno().sendKeys(mobileno);
		co.getSavebtn().click();

		
		//step-3 validation
		
		String OPO = co.getHeadertxt().getText();
		
	//	Assert.assertTrue(OPO.contains(cont1));

	}
}
