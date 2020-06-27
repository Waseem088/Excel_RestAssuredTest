package excel.Excel_RESTAssured;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
/*	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\sesa440442\\eclipse-workspace\\dataDriven.xlsx");
		//accepts fileInputStream argument
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			Iterator<Row> rows=sheet.iterator();
			Row firstrow=rows.next();
			Iterator<Cell> ce=firstrow.cellIterator();
			//to read each and every value
			int k=0;
			int column=0;
			while(ce.hasNext())
			{
				Cell value=ce.next();
				//want to read object value box
			 if(value.getStringCellValue().equalsIgnoreCase("testcases"))
			 {
				 column = k;
			 }
			k++;
			}
			System.out.println(column);
			
			//once column is identified then scan entire testcase column to identify purchase testcase row
			while(rows.hasNext())
			{
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase"))
				{
					//after grab purchase testcase row= pull all the data of that row and feed into test
					
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						System.out.println(cv.next().getStringCellValue());
					}
					
				}
			}
			
			           //here the o/p values are little bit ray o/p:  0
			                                                       // purchase
			                                                      // agagd
                                                                 // agdf
                                                                // fasd

		}
		}
		} 
}	*/

	//to get proper o/p here defining using ArrayList and calling the method in testSample class
	public ArrayList<String> getData(String testcaseName, String sheetName) throws IOException {
		
       ArrayList<String> a=new ArrayList<String>();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\sesa440442\\eclipse-workspace\\dataDriven.xlsx");
		//accepts fileInputStream argument
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
			{
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			Iterator<Row> rows=sheet.iterator();
			Row firstrow=rows.next();
			Iterator<Cell> ce=firstrow.cellIterator();
			//to read each and every value
			int k=0;
			int column=0;
			while(ce.hasNext())
			{
				Cell value=ce.next();
				//want to read object value box
			 if(value.getStringCellValue().equalsIgnoreCase("testcases"))
			 {
				 column = k;
			 }
			k++;
			}
			System.out.println(column);
			
			//once column is identified then scan entire testcase column to identify purchase testcase row
			while(rows.hasNext())
			{
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					//after grab purchase testcase row= pull all the data of that row and feed into test
					
					/*Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						
						a.add(cv.next().getStringCellValue());
					}*/
					
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						Cell c=cv.next();
						if(c.getCellTypeEnum()==CellType.STRING)
						{
						a.add(c.getStringCellValue());
						}
						else
						{
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
				}
					
				}
			}
			
		}	
		return a;
		
	} 


	}


