package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	public static void main(String[] args) {
		
		getExcelData();
		
		
	}
	
	public static String[][] getExcelData() 
	{
		String fileLocation = "./Testdata/LoginData.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
	
	    //	sheet.getLastRowNum(); >>> To get LastRowNum // To avoid null pointer exception , we specify the colcount ->> get the last colcount
	    int colCount = sheet.getRow(0).getLastCellNum();
	    // sheet.getRow(0).getLastCellNum(); >>> To get LastCellNum
		String[][] logindata = new String[rowCount][colCount]; // from
		for(int j=1;j<=rowCount;j++) {
	    XSSFRow row = sheet.getRow(j);
		for(int i=0;i<colCount ;i++) {
		XSSFCell cell = row.getCell(i);
		DataFormatter dft = new DataFormatter();
		//String cellvalue = dft.formatCellValue(cell);
		String cellvalue = cell.getStringCellValue();
		
		logindata[j-1][i] = cellvalue;
		System.out.println(cellvalue);
		}

		}
		System.out.println(rowCount   +"&"+  colCount);
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logindata;
	}
	

}