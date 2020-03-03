package com.qa.memdesk.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.memdesk.base.TestBase;
import com.qa.memdesk.pages.HomePage;
import com.qa.memdesk.pages.LoginPage;
import com.qa.memdesk.util.TestUtil;


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
	public void verifyMemberId(String memberId, String memberValue){
		System.out.println("Hello");
		homePage.SearchMemberBy(memberId,memberValue);
		Assert.assertEquals(homePage.getMemberId(), "jfaux_hh_testing");
	}
	
	@Test(priority=2,dataProvider = "LoginData")
	public void verifyContactPhone(){
		homePage.SearchMemberBy("Contact Phone Number","8182873200");
	}
	
	@DataProvider(name="LoginData")
	public Object[][] loginPagedata(){
		 Object[][] data = TestUtil.getTestData("");
	        return data;
	}
	@DataProvider(name="TestData")
	public Object[][] getTestData(){
		 Object[][] data = TestUtil.getRowData("","");
	        return data;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	} 
}