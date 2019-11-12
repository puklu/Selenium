

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ExcelDataProvider_POM {

	static XSSFSheet sheet ;
	static XSSFWorkbook workbook;
	static DealingWithExcel excel;
	
//	public ExcelDataProvider_POM(String filePath, String sheetName) throws IOException {
//		String projectPath = System.getProperty("user.dir");
//		workbook = new XSSFWorkbook(projectPath+filePath);
//		sheet = workbook.getSheet(sheetName);
//		excel =new DealingWithExcel(filePath, sheetName);
//		
//	}
	
	@Test(dataProvider="UNFTD_007")
	public void test1(String name, String metaTag, String model, double price, String category) throws IOException {
			
		System.out.println(name + " | " + metaTag + " | " + model  + " | " + price + " | " +category);
	}
	
	@DataProvider(name="UNFTD_007")
	public static Object[][] getData() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(projectPath+"/ExcelFiles/Pract2.xlsx");
		sheet = workbook.getSheet("TestData");
		excel =new DealingWithExcel(projectPath+"/ExcelFiles/Pract2.xlsx", "TestData");
		
        int startingRow = 44;
        int endingRow = 47;
        int startingCol = 2 ;
        int endingCol = 6;
		
		Object[][] data = new Object[endingRow - startingRow + 1 ][endingCol - startingCol + 1];
		
		for(int i= 0; i<endingRow - startingRow + 1; i++) {
			
			for(int j = 0; j<endingCol - startingCol + 1; j++) {
				
				if(j==3) {
					data[i][j] = excel.getCellDataNumeric((startingRow + i), (startingCol + j));
				}
				else
				data[i][j] = excel.getCellDataString(startingRow + i, startingCol + j);
//				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
}

