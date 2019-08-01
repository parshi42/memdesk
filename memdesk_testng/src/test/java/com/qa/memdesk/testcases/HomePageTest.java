package com.qa.memdesk.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.memdesk.base.TestBase;
import com.qa.memdesk.pages.HomePage;
import com.qa.memdesk.pages.LoginPage;


public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority=1)
	public void verifyMemberId(){
		homePage.SearchMemberBy("Member Id","jfaux_hh_testing");
		Assert.assertEquals(homePage.getMemberId(), "jfaux_hh_testing");
	}
	
	@Test(priority=2)
	public void verifyContactPhone(){
		homePage.SearchMemberBy("Contact Phone Number","8182873200");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
}