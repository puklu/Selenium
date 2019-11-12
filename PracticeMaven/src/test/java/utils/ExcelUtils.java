package utils;



import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		projectPath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		
	}
	
	
		public  int getRowCount() {
								
			    int rowCount = sheet.getPhysicalNumberOfRows();
//			    System.out.println("number of rows: "+rowCount);
			    return rowCount;
						
		}
		
		public  int getColCount() {
			
		    int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//		    System.out.println("number of columns: "+colCount);
		    return colCount;
					
	}
		
		public  String getCellDataString(int rownum, int colnum) {
						    
				String cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
//			    System.out.println(cellData);
			    return cellData;
			
		}
		
      public  double getCellDataNumeric(int rownum, int colnum) {
			
				double cellData = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
//			    System.out.println(cellData);
			    return cellData;
			    
		}
      
	

}
