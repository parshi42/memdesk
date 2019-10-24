package com.qa.memdesk.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.memdesk.base.TestBase;
import com.qa.memdesk.util.TestUtil;



public class HomePage extends TestBase{
	
	@FindBy(xpath = "//*[@id='searchBy']/tbody/tr/td[2]/input")
	WebElement dropdown_member;
	
	@FindBy(xpath = "//*[@id='searchBy_menu']/tbody")
	WebElement webtable;
	
	@FindBy(id = "memID")
	WebElement memberID;
	
	@FindBy(id = "accountInformation_label")
	WebElement FindAccount;
	
	@FindBy(id = "cp_memId")
	WebElement getMember;
	
	@FindBy(xpath = "//*[starts-with(@id,'dgrid_6-row-')]/table/tr/td[1]")
	WebElement selectaccount;
	
	@FindBy(id = "controlPanelTabContainer_tablist_dijit_layout_ContentPane_1")
	WebElement ticketspage;
	
	@FindBy(id = "cp_customerServiceTicket_label")
	WebElement newTicket;
	
	@FindBy(xpath = "//*[@id='accountDetailsTable']/tbody/tr[2]/td[1]/span")
	WebElement memberNumber;
		
	
	private static WebElement element = null;
	WebDriverWait wait = new WebDriverWait(driver, TestUtil.IMPLICIT_WAIT);
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchMemberBy(String searchby, String member){
		
		if(dropdown_member.isDisplayed() && dropdown_member.isEnabled()){
			
			dropdown_member.click();
			TestUtil.HandlingWebTable(webtable, searchby);
			memberID.sendKeys(member);
			FindAccount.click();	
			if(selectAccount(driver) != null){		
				if(selectAccount(driver).isDisplayed() && selectAccount(driver).isEnabled()){
					selectAccount(driver).click();
				}
			}
			WebDriverWait wait = new WebDriverWait(driver, TestUtil.IMPLICIT_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""
					+ "controlPanelTabContainer_tablist_dijit_layout_ContentPane_1"))
			);
		
		}
	}
	
	public String getMemberId(){
		return getMember.getText();
	}
	

	 public static WebElement selectAccount(WebDriver driver) throws NullPointerException{
		 
		   try{

	        element = driver.findElement(By.xpath(".//span[text()='OK']"));
		   }
		   catch(NoSuchElementException e){
			    element=null;
				//System.out.println("MessageWindow ok button not found: " +e.toString());
				}
		   
	        return element;
	 }
	 
	 public TicketsPage getticketsPage(){
		 if(!memberNumber.getText().isEmpty()){
			 ticketspage.click();			 
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cp_customerServiceTicket_label")));
			 newTicket.click();
		 }
		 return new TicketsPage();
	 }

}