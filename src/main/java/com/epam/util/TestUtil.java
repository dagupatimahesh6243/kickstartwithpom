package com.epam.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {
    public static String TEST_DATA_PATH="src/main/java/com/epam/testData/MyTestData";
    static XSSFWorkbook xssfWorkbook;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        Object[][] testData;
        dataFileSetup();
        testData= getMyData(sheetName);
        return testData;
    }
    public static void dataFileSetup() {
        FileInputStream file=null;
        try {
            file = new FileInputStream(TEST_DATA_PATH);
            xssfWorkbook=new XSSFWorkbook(file);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object[][] getMyData(String sheetName) {
        sheet = xssfWorkbook.getSheet(sheetName);
        int numberOfRows=sheet.getLastRowNum();
        int numberOfColumns=sheet.getRow(0).getLastCellNum();
        Object[][] data= new Object[numberOfRows][numberOfColumns];
        for(int i=0;i<numberOfRows;i++) {
            for(int j=0;j<numberOfColumns;j++) {
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}
