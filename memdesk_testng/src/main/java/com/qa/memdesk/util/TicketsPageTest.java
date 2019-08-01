package com.qa.memdesk.util;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.memdesk.base.TestBase;
import com.qa.memdesk.pages.HomePage;
import com.qa.memdesk.pages.LoginPage;
import com.qa.memdesk.pages.TicketsPage;

public class TicketsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TicketsPage ticketsPage;
	TicketsPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.SearchMemberBy("Member Id","jfaux_hh_testing");
		ticketsPage = homePage.getticketsPage();
	}

	@Test(priority=1)
	public void verifydslPrequalifybtn(){
		
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
