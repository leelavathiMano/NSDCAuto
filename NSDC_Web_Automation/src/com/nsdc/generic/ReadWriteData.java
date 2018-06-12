package com.nsdc.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteData
{
    public static String getData(String filepath, String sheetName, int rowIndex, int cellIndex)
    {
        String TestData = null;
        try
        {
            File f = new File(filepath);
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
    public static void setExcelData(String filepath, String sheetname, int rowIndex, int cellIndex, String testData)
    {
        try
        {
            File f = new File(filepath);
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
    }
}

