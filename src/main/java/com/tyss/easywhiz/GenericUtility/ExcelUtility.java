package com.tyss.easywhiz.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.protobuf.Value;

public class ExcelUtility {

	/**
	 * this method is for fetching particular row and cell data
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String readTheDataFromExcelSheet(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		String value = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to count the total row in the excel file
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * This method is used to write the data into Excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int rowNum, int cellNum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.createSheet(sheetName);
		sheet.createRow(0).createCell(0).setCellValue(value);
		FileOutputStream fout=new FileOutputStream(IPathConstant.EXCELPATH);
		workbook.write(fout);
		workbook.close();
		
	}
	
	
	public HashMap<String,String> readMultipleData(String sheetName, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <=rowCount; i++) {
			String key = sheet.getRow(i).getCell(cellNo).getStringCellValue();
			String value = sheet.getRow(i).getCell(cellNo+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
		
	}
}
