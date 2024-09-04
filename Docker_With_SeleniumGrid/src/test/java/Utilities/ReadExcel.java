package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	String path;

	public ReadExcel(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) {
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		try {
			fis.close();
			wb.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rowCount;
	}
	public int getCellCount(String sheetName,int rowNum) {
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		try {
			fis.close();
			wb.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cellCount;
	}

	public String getCellData(String sheetName,int rowNum,int cellNum) {
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sheet = wb.getSheet(sheetName);
		 row = sheet.getRow(rowNum);
		 cell = row.getCell(cellNum);
		 DataFormatter df = new DataFormatter();
		 try {
			fis.close();
			wb.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return df.formatCellValue(cell);
	}

	
	
}
