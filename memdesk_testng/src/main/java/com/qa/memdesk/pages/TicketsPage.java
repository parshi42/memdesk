package com.qa.memdesk.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.memdesk.base.TestBase;

public class TicketsPage extends TestBase{
	
	@FindBy(id = "dijit_form_Button_427_label")
	WebElement dslPrequalify;	
	
	@FindBy(css = "textarea[id$='_agentWorklog']")
	WebElement worklog;
	
	@FindBy(css = "div[id*='_category_popup']")
	List<WebElement> category;
	
	@FindBy(css = "div[id*='_type_popup']")
	WebElement type;
	
	// Initializing the Page Objects:
	public TicketsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getdslPrequalifybtn(){
		return worklog.isDisplayed();
	}
	
	public void verifyticketCreation(){
		
	}
	
}
