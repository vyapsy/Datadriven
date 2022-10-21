package Exampl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadr {
	
	public ArrayList<String> getData(String TCname) throws IOException {
	
	
       
		ArrayList<String> a= new ArrayList();

		FileInputStream exc = new FileInputStream("src\\test\\\\resources\\Testing.xlsx");

		XSSFWorkbook workbk = new XSSFWorkbook(exc);

		int sheets = workbk.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbk.getSheetName(i).equalsIgnoreCase("QA")) {
				XSSFSheet index = workbk.getSheetAt(i);
				// regarding coloumn header-> 1st row

				Iterator<Row> rows = index.rowIterator();
				Row firstrow = rows.next();

				// cell by cell in 1st row9
				Iterator<Cell> ce = firstrow.cellIterator();

				int k = 0;
				int coloum = 0;

				while (ce.hasNext()) {
					Cell value = ce.next();
					// System.out.println(value);

					if (value.getStringCellValue().equalsIgnoreCase("test")) {
						// System.out.println("We are at desired coloumn");
						coloum = k;
					}
					k++;

				}

				System.out.println(coloum);

				// once coloum is identified- scan entire coloumn data

				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(coloum).getStringCellValue().equalsIgnoreCase(TCname)) {
						// grab all cells of prchase row

						Iterator<Cell> cv = r.cellIterator();

						while (cv.hasNext()) {
							Cell c =cv.next();
							if(c.getCellTypeEnum()==CellType.STRING) 
							{
								
							a.add(c.getStringCellValue());
							}
							else
							{
							
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));  // convert int to string
							}
							
						}

					}
					
				}
			}

		}
					return a;
	}
	public static void main(String[] args) throws IOException {
}
}