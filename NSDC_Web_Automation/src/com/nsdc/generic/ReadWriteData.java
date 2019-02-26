package com.nsdc.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteData
{
	
    public static String getData(String fileFilepath, String sheetName, int rowIndex, int cellIndex)
    {
        String TestData = null;
        try
        {
            File f = new File(fileFilepath);
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet st = wb.getSheet(sheetName);
            Row r = st.getRow(rowIndex);
            Cell c = r.getCell(cellIndex);
            TestData = c.toString();
         }
        catch(Exception e)
        {
        	
        }
        return TestData;
    }
    
    public static void setExcelData(String Filepath, String SheetName, int RowNum, int ColNum, String Data) throws Exception
    {
        FileInputStream fs = new FileInputStream(Filepath);
        Properties FilepathConfig = new Properties(System.getProperties());
        FilepathConfig.load(fs);
        
        FileInputStream ExcelFile = new FileInputStream(Filepath);
        @SuppressWarnings("resource")
		HSSFWorkbook ExcelWBook = new HSSFWorkbook(ExcelFile);
        
    	MissingCellPolicy xRow = null;
    	
        try
        {   
        	HSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);
        	HSSFRow Row  = ExcelWSheet.getRow(RowNum);
            @SuppressWarnings("static-access")
			org.apache.poi.ss.usermodel.Cell Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);
            if (Cell == null)
            {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Data);
            }
            else
            {
                Cell.setCellValue(Data);
            }
            
            FileOutputStream fileOut = new FileOutputStream(Filepath);
            ExcelWBook.write(fileOut);
            //fileOut.flush();
            fileOut.close();
            ExcelWBook = new HSSFWorkbook(new FileInputStream(Filepath));
            ExcelWBook.getCreationHelper().createFormulaEvaluator().evaluateAll();
            
        }
        catch (Exception e)
        {           
        	
        }
    }
    
    /*public static void setExcelData(String fileFilepath, String sheetname, int rowIndex, int cellIndex, String testData)
    {
        try
        {
            File f = new File(fileFilepath);
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet st = wb.getSheet(sheetname);
            Row r = st.getRow(rowIndex);
            Cell c = r.getCell(cellIndex);
            c.setCellValue(testData);
            FileOutputStream fos = new FileOutputStream(f);
            wb.write(fos);
        }
        catch(Exception e)
        {
        	
        }
    }*/
    
    public static String getToT_ToA_ConfigData(String fileFilepath, String sheetName, int rowIndex, int cellIndex)
    {
        String TestData = null;
        try
        {
            File f = new File(fileFilepath);
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet st = wb.getSheet(sheetName);
            Row r = st.getRow(rowIndex);
            Cell c = r.getCell(cellIndex);
            TestData = c.getStringCellValue();
         }
        catch(Exception e)
        {
        	
        }
        return TestData;
    }
}