package DataProviderTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelfilez {
	DataFormatter format= new DataFormatter();
	
	@Test(dataProvider="xlfile")
	public void testcaseData(String greetings, String Communication, String ID ) {
		System.out.println(greetings+" "+Communication+"  "+ID);
	}
	
	
	
	@DataProvider(name="xlfile")
	
public Object[][] ExcelTest( ) throws IOException {    // Object [][] array means it may be int string, or any data type
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\TestBook.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		//System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
		
		int rowcount= sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int coloumnCount=row.getLastCellNum();
		
		
	Object data[][] = new Object[rowcount-1][coloumnCount];
		
	//to get content in excel , to store each row in a list
	
	for(int i=0; i<rowcount-1; i++ ) {
		
		row=sheet.getRow(i+1); // exclude 1st row= header
		
		for(int j=0; j<coloumnCount; j++ ) {
			
			XSSFCell cell=row.getCell(j);
			 
			data[i][j]= format.formatCellValue(cell); // format string
			//System.out.println(data[i][j]);
		}
	}
		return data;
	}
}
