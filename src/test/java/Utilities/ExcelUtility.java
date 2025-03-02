package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import freemarker.log.Logger;

public class ExcelUtility {

	public File file;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public void readFile() {
		try {
			file = new File("./TestData//TestData.xlsx");
			if (file.exists()) {
				fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet("TestDataSheet1");
				workbook.close();
				fis.close();
			} else {
				throw new FileNotFoundException("file doesnt exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		readFile();
		return sheet.getLastRowNum();
	}

	public int cellCount() {
		int rowNum = getRowCount();
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		return cellCount;
	}

	public String getCellData(int rownum, int colnum) {
		readFile();
		DataFormatter formatter = new DataFormatter();
	
		try {
			String cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			if(cellData==null) {
				
			}
			else {
				formatter.formatCellValue(cell);
			}
			
			return cellData;
		} catch (Exception e) {
			return " ";
		}
		
	}
}
