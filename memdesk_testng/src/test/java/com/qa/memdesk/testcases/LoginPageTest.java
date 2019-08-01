package com.qa.memdesk.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.memdesk.pages.LoginPage;
import com.qa.memdesk.base.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}

	@Test(priority=1)
	public void validateLoginPageTitle(){
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Memdesk Application");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
