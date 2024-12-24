package com.tka.utilities.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AdminProperty {

	public static String valueofAnyKey(String Anykey) throws Exception
	{
		FileInputStream inputStream = new FileInputStream(".\\PropertyFile\\Config.properties");

		Properties pro= new Properties();
		pro.load(inputStream);
		return pro.getProperty(Anykey);
		
		
	}
	
	

}
