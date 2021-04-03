package com.vtiger.genericRepository;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataHandler
{
	public String getPropertykeyValue(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/Datastorage/comondata.properties");
		Properties prop= new Properties();
		prop.load(fis);
		return prop.getProperty(key);	
	}
	public static void main(String[] args) throws Throwable 
	{
		System.out.println(new DataHandler().getPropertykeyValue("browser"));
		System.out.println(new DataHandler().getPropertykeyValue("url"));
		System.out.println(new DataHandler().getPropertykeyValue("username"));
		System.out.println(new DataHandler().getPropertykeyValue("password"));
	}
	
}
