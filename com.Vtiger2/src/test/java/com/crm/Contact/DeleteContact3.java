package com.crm.Contact;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.List;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.objectelementrepositoryutility.contact;
import com.vtiger.genericRepository.Baseclass;
import com.vtiger.genericRepository.DataHandler;
import com.vtiger.genericRepository.Excelorg;
import com.vtiger.genericRepository.WebDrivirUtilit;
import com.vtiger.genericRepository.classutility;

public class DeleteContact3 extends Baseclass
{

	@Test
	public void DeleteContact() throws Exception 
	{
		
		DataHandler d = new DataHandler();
		classutility c = new classutility();
		WebDrivirUtilit u= new WebDrivirUtilit();
		Excelorg e = new Excelorg();

		
		String oname = e.getDataFromExcel("sheet2","Tc_01", "contact Name") + c.genrateRandomnum();
		String contactname = e.getDataFromExcel("sheet2","Tc_02","contact Name") + c.genrateRandomnum();
		String mobileno = e.getDataFromExcel("sheet2","Tc_04","contact Name");
		String phoneno = e.getDataFromExcel("sheet2","Tc_05","contact Name");

		System.out.println(oname);
		System.out.println(contactname);
		
		/* step-1 navigate to Contacts */
		contact cu = PageFactory.initElements(driver, contact.class);
		cu.getContctlink().click();
		
		//step-2 navigate to create contact
		
		cu.getCreatecontc().click();

		cu.getSelectcl().click();
		
		cu.getFirstnameedit().sendKeys(oname);
		cu.getLastname().sendKeys(contactname);	
		cu.getPhoneno().sendKeys(mobileno);
		cu.getMobileno().sendKeys(phoneno);
		cu.getSavebtn().click();
		
		cu.getContctlink().click();
	
		// step-3 delete contact
		
		List<WebElement> alts = cu.getAllcntcs();
		for(WebElement wb: alts)
		{
			System.out.println(wb.getText());
			
			
			if(wb.getText().startsWith(oname))
			{
				wb.click();
				System.out.println("PASS");
			}
			
			
		}
		 	
		cu.getDeletebtn().click();
	
		driver.switchTo().alert().accept();

		
	}
}
