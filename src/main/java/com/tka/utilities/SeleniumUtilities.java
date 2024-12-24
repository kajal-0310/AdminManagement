package com.tka.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtilities {
	
	public static  WebDriver openBrowser()
	{
		WebDriver driver= new ChromeDriver();
		return driver;
	}

	
	public static void Openurl(WebDriver driver,String openUrl)
	{
		driver.get(openUrl);
	}
	
	
	public static void ClickButton(WebDriver driver, String xpath)
	{
	driver.findElement(By.xpath(xpath)).click();

	}
	
	public static void   EnterText(WebDriver driver, String xpath,String data)
	{
		
	driver.findElement(By.xpath(xpath)).sendKeys(data);

	}
	
	public static String  GetText(WebDriver driver, String xpath)
	{
		
	String text =driver.findElement(By.xpath(xpath)).getText();
	return text;

	}
	
	public static void redioButtonClick(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id=\"Female\"]")).click();
	}
	
	public static void selectDropdown(WebDriver driver)
	{
		WebElement ele=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
		ele.click();
		Select sc= new Select(ele);
		sc.selectByIndex(1);
	}

}
