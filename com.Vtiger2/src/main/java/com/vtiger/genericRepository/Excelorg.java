package com.vtiger.genericRepository;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.reporters.jq.Main;

public class Excelorg 
{
  		
	public String getreadExcelData(String SheetName,int num,int cellNum) throws IOException
	{
		
		FileInputStream fis = new FileInputStream("./src/main/resources/Datastorage/testyantra.xlsx");
		Workbook wb	=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
			Row r= sh.getRow(num);
			String data = r.getCell(cellNum).getStringCellValue();
			System.out.println(data);
			return data;	
	}
	public String getDataFromExcel(String SheetName,String TestcaseId,String columnHeader) throws IOException
	{
		
		int expectedRow=0;
		int expectedColumn=0;
		
		FileInputStream fis = new FileInputStream("./src/main/resources/Datastorage/testyantra.xlsx");
		Workbook wb	=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
			int lrn = sh.getLastRowNum();
			
			for(int i=0;i<=lrn;i++)
			{
				String actid = sh.getRow(i).getCell(0).getStringCellValue();
				if(actid.equals(TestcaseId))
				{
					expectedRow=i;
					break;
				}
			}
			
			 int lCn = sh.getRow(expectedRow).getLastCellNum();
			 for(int j=0;j<lCn;j++)
			 {
				 String act2h = sh.getRow(0).getCell(j).getStringCellValue();
				 if(act2h.equals(columnHeader))
				 {
					 expectedColumn=j;
					 break;
				 }
			 }
			return sh.getRow(expectedRow).getCell(expectedColumn).getStringCellValue();
	}
		
	
		public static void main(String[] args) throws IOException
		{
			
			String org = new Excelorg().getDataFromExcel("sheet2", "Tc_02", "org name");
			System.out.println(org);
		}
	
}
