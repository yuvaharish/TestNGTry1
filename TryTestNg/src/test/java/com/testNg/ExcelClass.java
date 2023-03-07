package com.testNg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelClass {
	

	String[][]data={{"admin","admin1"},
		{"admin","admin1"},
		{"admin","admin1"},
		{"admin","admin1"},
			{"admin123"},{"admin"},	
	};
	
	
	@DataProvider(name="logindata")
	public String[][] logindata() {
		return data;	
	}
	@Test(dataProvider="logindata")
	public void loginbrowser(String name,String pass) {
		
	}
	
	
	public static void main(String[] args) throws IOException {
	
		
		
	}

}
