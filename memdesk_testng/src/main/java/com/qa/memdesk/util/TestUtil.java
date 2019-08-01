package com.qa.memdesk.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.memdesk.base.TestBase;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = "D:/memdesk_testng/src/main/java/com/qa/memdesk/testdata/TestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void HandlingWebTable(WebElement webtable, String ele){
		  

	     List<WebElement> rows_table  = webtable.findElements(By.tagName("tr"));
	     
	     for (WebElement elr : rows_table){ 
	  	   
	  	 //To locate columns(cells) of that specific row.
	     //System.out.println("Cell Value2 " + rows_table);  
	    	 List<WebElement> Columns_row = elr.findElements(By.tagName("td")); 
	  	 
	  	 for (WebElement elc : Columns_row){ 
	  		 
	  	 // To retrieve text from that specific cell.
	  		 
	  	 String celtext = elc.getText();
	  	 //System.out.println("Cell Value " +celtext);
	  	 if(celtext.equalsIgnoreCase(ele)){    		 
	  		 elc.click();	  		
	  		 break;
	  	 }
	  	 }
	  	 }
	}
}