package com.nsdc.generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;

public class ReadMultipleDataFromExcel
{
    public static Object[][] getExcelData(String filepath, String sheetname)
    {
        String[][] arrayExcelData = null;
        try
        {
            File f = new File(filepath);
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = Workbook.getWorkbook(fis);
            Sheet sh = wb.getSheet(sheetname);
            int totalNoOfCols = sh.getColumns();
            int totalNoOfRows = sh.getRows();
            
            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
            
            for (int i=1; i < totalNoOfRows; i++)
            {
                for (int j=0; j < totalNoOfCols; j++)
                {
                	
					/*
					 * Random rand = new Random();
					 * 
					 * // Generate random integers in range 0 to 999 int rand_int1 =
					 * rand.nextInt(1000); String AutoRand = "Auto_"+rand_int1; // Print random
					 * integers System.out.println(AutoRand); ReadWriteData.setExcelData(
					 * "./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
					 * "ProjectAndBatchCreation", i-1, 8, AutoRand);
					 */
                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
    
    public static Object[][] getLoginCredentials(String filepath, String sheetname)
    {
        String[][] arrayExcelData = null;
        try
        {
            File f = new File(filepath);
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = Workbook.getWorkbook(fis);
            Sheet sh = wb.getSheet(sheetname);
            int totalNoOfRows = sh.getRows();
            
            arrayExcelData = new String[totalNoOfRows-1][2];
            
            for (int i=1; i < totalNoOfRows; i++)
            {
                for (int j=0; j < 2; j++)
                {
                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
    
    

    public static Object[][] getAllExcelData(String filepath, String sheetname)
    {
        String[][] arrayExcelData = null;
        try
        {
            File f = new File(filepath);
            FileInputStream fis = new FileInputStream(f);
           // @SuppressWarnings("resource")
            XSSFWorkbook ExcelWBook = new XSSFWorkbook(fis);

        	//MissingCellPolicy xRow = null;
            	XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheetname);
            	XSSFRow Row  = ExcelWSheet.getRow(0);
            	 int totalNoOfCols = Row.getLastCellNum();
            	 
            	 int totalNoOfRows = ExcelWSheet.getLastRowNum()+1;
          
            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
            
            for (int i=1; i < totalNoOfRows; i++)
            {
                for (int j=0; j < totalNoOfCols; j++)
                {
                	
					/*
					 * Random rand = new Random();
					 * 
					 * // Generate random integers in range 0 to 999 int rand_int1 =
					 * rand.nextInt(1000); String AutoRand = "Auto_"+rand_int1; // Print random
					 * integers System.out.println(AutoRand); ReadWriteData.setExcelData(
					 * "./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
					 * "ProjectAndBatchCreation", i-1, 8, AutoRand);
					 */
                    arrayExcelData[i-1][j] = ExcelWSheet.getRow(i).getCell(j).toString();
                    		//getCell(j, i).getContents();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return arrayExcelData;
    }
    
    
    
    
}

