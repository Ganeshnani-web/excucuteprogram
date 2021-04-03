package com.vtiger.genericRepository;

import java.awt.RadialGradientPaint;
import java.util.Date;
import java.util.Random;

public class classutility   
{
	public int genrateRandomnum()
	{
		Random r = new Random();
		 return r.nextInt(1000);
	}
	public String getDateAndTime()
	{
		Date d = new Date();
	
		return d.toString();
	}
	public static void main(String[] args)
	{
		System.out.println(new classutility().genrateRandomnum());
		System.out.println(new classutility().getDateAndTime());
			
	}	

}
