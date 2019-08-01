package com.qa.memdesk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.memdesk.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id = "loginPage_agentId")
	WebElement UserName;
	@FindBy(id = "loginPage_password")
	WebElement Password;
	@FindBy(id = "loginPage_loginBtn_label")
	WebElement LoginBtn;
	
	private static WebElement element = null;
	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public HomePage login(String un, String pwd){
		
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();	
		
		if(OkBtn(driver) != null){		
		if(OkBtn(driver).isDisplayed() && OkBtn(driver).isEnabled()){
			OkBtn(driver).click();
		}
		}
		if(OkayBtn(driver) != null){
		if(OkayBtn(driver).isDisplayed() && OkayBtn(driver).isEnabled()){
			OkayBtn(driver).click();
		}
		}
		return new HomePage();
	}
	
	 
	 public static WebElement OkBtn(WebDriver driver) throws NullPointerException{
		 
		   try{

	        element = driver.findElement(By.xpath(".//span[text()='OK']"));
		   }
		   catch(NoSuchElementException e){
			    element=null;
				//System.out.println("MessageWindow ok button not found: " +e.toString());
				}
		   
	        return element;
	 }
	 public static WebElement OkayBtn(WebDriver driver) throws NullPointerException{
		 
		   try{

	        element = driver.findElement(By.xpath(".//span[text()='OKAY']"));
		   }
		   catch(NoSuchElementException e){
			    element=null;
				//System.out.println("MessageWindow okay button not found: " +e.toString());
				}
		   
	        return element;
	 }
			
}