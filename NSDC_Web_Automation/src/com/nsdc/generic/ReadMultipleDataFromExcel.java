package com.nsdc.generic;

import java.io.File;
import java.io.FileInputStream;

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
    
}

