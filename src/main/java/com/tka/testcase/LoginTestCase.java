package com.tka.testcase;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.tka.utilities.SeleniumUtilities;
import com.tka.utilities.prop.AdminProperty;

public class LoginTestCase  {
	
	WebDriver driver=null;
	@BeforeMethod
    public void AdminPage() throws Exception
    {
	 driver = SeleniumUtilities.openBrowser();
	 SeleniumUtilities.Openurl(driver, AdminProperty.valueofAnyKey("url"));
    }
	@AfterMethod
	void closeBrowser() {
		
		driver.quit();
	}


	@Test (enabled=false)
	public void TestSubHeading()
	{
		
	
		String actResult = SeleniumUtilities.GetText(driver, "/html/body/div/div[2]/p[1]");
		String expResult = "welcome to kiran academy";
		Assert.assertEquals(actResult, expResult);

	}

	@Test (enabled=false)
	public void TestMainHeading() 
	{
		String actResult = SeleniumUtilities.GetText(driver, "/html/body/div/div[1]/a/b");
		String expResult = "Java By Kiran";
		Assert.assertEquals(actResult, expResult);

	}
	@Test (enabled=false)
	public void testSubHeadingContent() 
	{
		String actResult = SeleniumUtilities.GetText(driver, "/html/body/div/div[1]/a/h4");
		String expResult = "Java By Kiran";
		Assert.assertEquals(actResult, expResult);

	}
	
	
	@Test (enabled=false)
	public void  testValidlogincreditials()
	{
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", "kiran@gmail.com");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]","123456");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"form\"]/div[3]/div/button");
		String actresult = SeleniumUtilities.GetText(driver, "/html/body/div/div[1]/section[1]/ol/li[2]");
		System.out.println(actresult);
		String expresult = "Dashboard";
		Assert.assertEquals(actresult, expresult,"text not found");
	}
	
	@Test (enabled=false)
	public void  testInvalidUsernamecreditials()
	{
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", "abcd@gmail.com");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]","123456");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"form\"]/div[3]/div/button");
		String actresult = SeleniumUtilities.GetText(driver, "//*[@id=\"email_error\"]");
		System.out.println(actresult);
		String expresult = "Dashboard";
		Assert.assertEquals(actresult, expresult);
	}
	
	@Test(enabled=false)
	public void  testInvalidPasswordcreditials()
	{
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", "kiran@gmail.com");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]","123456#");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"form\"]/div[3]/div/button");
		String actresult = SeleniumUtilities.GetText(driver, "//*[@id=\"password_error\"]");
		System.out.println(actresult);
		String expresult = "login failed";
		Assert.assertEquals(actresult, expresult);
	}
	@Test (enabled=false)
	public void testInvalidLoginCreditials()
	{
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", "kiran#gmail.com");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]","123456#");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"form\"]/div[3]/div/button");
		String actresult = SeleniumUtilities.GetText(driver, "//*[@id=\"password_error\"]");
		System.out.println(actresult);
		String expresult ="login successfully";
		Assert.assertEquals(actresult, expresult);
	}
	@Test (enabled=false)
	public void testEnterBlankCreditials()
	{
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", "");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]","");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"form\"]/div[3]/div/button");
		SeleniumUtilities.GetText(driver, "//*[@id=\"email_error\"]");
		String actresult = SeleniumUtilities.GetText(driver, "//*[@id=\"password_error\"]");
		System.out.println(actresult);
		String expresult ="Please enter password";
		Assert.assertEquals(actresult, expresult);
	}
	
	@Test (enabled=false)
	public void testNewRegistermember()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div/div[2]/a");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"name\"]", "abacd");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"mobile\"]", "87987654");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", "abcd@gmail.com");
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]", "123456");
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"form\"]/div[5]/div/button");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}	
	
	@Test (enabled=false)
	public void testNewRegisterHeading()
	{
		SeleniumUtilities.ClickButton(driver, "/html/body/div/div[2]/a");  
		String actResult=SeleniumUtilities.GetText(driver, "/html/body/div/div[2]/p");
		String expResult="Resgister new member";
		Assert.assertEquals(actResult, expResult);
	}
	
	@Test(dataProvider = "logindata")
	public void checkInvalidCredintialMessage(String username,String password,String check)
	{
		SeleniumUtilities.EnterText(driver, "//*[@id=\"email\"]", username);
		SeleniumUtilities.EnterText(driver, "//*[@id=\"password\"]", password);
		SeleniumUtilities.ClickButton(driver, "//*[@id=\"form\"]/div[3]/div/button");
		String actResult=SeleniumUtilities.GetText(driver, "//*[@id=\"email_error\"]");
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		

	if(check.equals("1"))
	{
		String actemailerror=SeleniumUtilities.GetText(driver, "//*[@id=\"email_error\"]");
		String expemailerror="please enter email";
		Assert.assertEquals(actemailerror, expemailerror);
	}
	else if(check.equals("2"))
	{
		String actpassworderror=SeleniumUtilities.GetText(driver, "//*[@id=\"password_error\"]");
		String exppassworderror="please enter password";
		Assert.assertEquals(actpassworderror,exppassworderror);
	}
	else if(check.endsWith("3"))
	{
		String actemailerror=SeleniumUtilities.GetText(driver, "//*[@id=\"email_error\"]");
		String expemailerror="please enter valid  email";
		Assert.assertEquals(actemailerror, expemailerror);
	}
	else if(check.endsWith("4"))
	{
		String actpassworderror=SeleniumUtilities.GetText(driver, "//*[@id=\"password_error\"]");
		String exppassworderror="please enter valid  password";
		Assert.assertEquals(actpassworderror,exppassworderror);
	}
	else if(check.endsWith("5"))
	{
		String actemailerror=SeleniumUtilities.GetText(driver, "//*[@id=\"email_error\"]");
		String expemailerror="Invalid username and password";
		Assert.assertEquals(actemailerror, expemailerror);
	}
	}


	
 @DataProvider public Object[][] logindata()
 {
	
	return  new Object[][]
   {
		    new Object[] {" " , "123456","1"},
			new Object[] {"kiran@gmail.com " , " ","2"},
			new Object[] {"abc" , "123456","3"},
		    new Object[] {" kiran@gmail.com" , "123@","4"},
		    new Object[] {" admin" , "password","5"},
   };
   }
}

		
	


	

	
	
	



	
	
	

