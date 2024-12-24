package com.tka.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tka.utilities.SeleniumUtilities;
import com.tka.utilities.prop.AdminProperty;

public class DashboardTestCases 
{
	WebDriver driver=null;
	@BeforeClass
    public void AdminPage() throws Exception
    {
	 driver = SeleniumUtilities.openBrowser();
	 SeleniumUtilities.Openurl(driver, AdminProperty.valueofAnyKey("DashboardURL"));
    }
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	
	
	@Test(enabled=false)
	public void verifyDashboardMainHeading()
	{
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div/header/a/span[2]/b");
		String expResult="kiran academy";
		Assert.assertEquals(actResult, expResult);
	}
	
	

	@Test(enabled=false)
	public void verifyDashboardSubHeading()
	{
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div/div[1]/section[1]/h1");
		String expResult="Dashboard";
		Assert.assertEquals(actResult, expResult);
	}
	
	
	
	@Test(enabled=false)
	public void verifyTitleofDashboard()
	{
		String actResult=driver.getTitle();
		System.out.println(actResult);
		String expResult="JavaByKiran | Dashboard";
		Assert.assertEquals(actResult, expResult);
		
	}
	
	
	@Test(enabled=false)
	    public void verifyCoursesOffered()
	{
	    ArrayList<String> expResult = new ArrayList<>(Arrays.asList("Selenium", "Java / J2EE", "Python", "Php"));
	    ArrayList<String> actResult = new ArrayList<>();
	    for (int i = 1; i <= 4; i++)
    {
	    String courseText = SeleniumUtilities.GetText(driver, "//section[2]//div[" + i + "]//h3");
	    actResult.add(courseText); 
	}
	    Assert.assertEquals(actResult, expResult);
	}
	
	
	@Test(enabled=false)
	public void verifyUsersList()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div[1]/aside/section/ul/li[3]/a/span");
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div[1]/div[1]/section[1]/h1");
		String expResult="Users";
		Assert.assertEquals(actResult, expResult);
	}
	
	
	@Test (enabled=false)
	public void verifyUserMainheading()
	{
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/h3");
		String expResult="Users";
		Assert.assertEquals(actResult, expResult);
	}
	
	
	@Test (enabled=false)
	public void testAddUsersSubHeading()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div[1]/aside/section/ul/li[3]/a");
		SeleniumUtilities.ClickButton(driver, "/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button");
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div/div[1]/section[2]/div/div/div/div/h3");
		String expResult="Add details";
		Assert.assertEquals(actResult, expResult);
		
	}
	
	@Test (enabled=false)
	public void verifyUserTableHeaders()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div[1]/aside/section/ul/li[3]/a/span");
		ArrayList<String> alexpResult= new ArrayList<String>();
		alexpResult.add("#");
		alexpResult.add("Username");
		alexpResult.add("Email");
		alexpResult.add("Mobile");
		alexpResult.add("Course");
		alexpResult.add("Gender");
		alexpResult.add("State");
		alexpResult.add("Action");
		
		ArrayList<String> alactResult=new ArrayList<String>();
    	List<WebElement> list=driver.findElements(By.xpath("//table//tr/th"));
    	for (WebElement webElement : list)
    	{
			String data=  webElement.getText();
			alactResult.add(data);
		}
    	Assert.assertEquals(alactResult, alexpResult);
     }
	

	
	@Test (enabled=false)
	public void verifyRemoveUserfromUserList()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div[1]/aside/section/ul/li[3]/a/span");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"tr_4\"]/td[8]/a/span");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	
	@Test (enabled=false)
	public void verifyOperatorsHeading()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div/aside[1]/section/ul/li[4]/a");
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div/div[1]/section[1]/h1");
		String expResult="Operators";
		Assert.assertEquals(actResult, expResult);
		
	}
	
	@Test (enabled=false)
	public void verifyOperatorsSubHeading()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div/aside[1]/section/ul/li[4]/a");
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div/div[1]/section[2]/div/div/div/div[1]/h3");
		String expResult="Operators";
		Assert.assertEquals(actResult, expResult);
		
	}
	
	@Test (enabled=false)
	public void verifyOperatorListHeaders()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div/aside[1]/section/ul/li[4]/a");
		ArrayList<String> alexpResult= new ArrayList<String>();
		alexpResult.add("Id");
		alexpResult.add("Username");
		alexpResult.add("Email");
		alexpResult.add("Mobile");
		alexpResult.add("Course");
		alexpResult.add("Gender");
		ArrayList<String> alactResult=new ArrayList<String>();
    	List<WebElement> list=driver.findElements(By.xpath("//table//tr/th"));
    	for (WebElement webElement : list)
    	{
			String data=  webElement.getText();
			alactResult.add(data);
		}
    	Assert.assertEquals(alactResult, alexpResult);
		
	}
	
	@Test (enabled=false)
	public void verifyLogoutaccount()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div/aside[1]/section/ul/li[7]/a/span");
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div/div[2]/p[2]");
		String expResult="logout successfully";
		Assert.assertEquals(actResult, expResult);
	}
	
	@Test (enabled=false)
	public void verifyAddNewUser() 
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div/aside/section/ul/li[3]/a/span");
		SeleniumUtilities.ClickButton(driver, "/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"username\"]", "Tom");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"mobile\"]", "78976554");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", "Tom@gmail.com");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"course\"]", "Java");
		SeleniumUtilities.redioButtonClick(driver);
		SeleniumUtilities.selectDropdown(driver);
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]", "123456");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"submit\"]");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		String actResult = alert.getText();
		String expResult="user not added";
	    Assert.assertEquals(actResult, expResult);
	    alert.accept();	
	}
	
	
	@Test
	public void verifyMainNavigations()
	{
		ArrayList<String> alexpResult= new ArrayList<String>();
		alexpResult.add("Dashboard");
		alexpResult.add("Users");
		alexpResult.add("Operators");
		alexpResult.add("Useful Links");
		alexpResult.add("Downloads");
		alexpResult.add("Logout");
		ArrayList<String> alactResult= new ArrayList<String>();
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='sidebar-menu']//span"));
    	for (WebElement webElement : list)
    	{
			String data=  webElement.getText();
			alactResult.add(data);
		}
    	Assert.assertEquals(alactResult, alexpResult);
		
		
	}
	
	
	
	
	
	}
	
	
	
	

	
	
	
	

	
	
	

