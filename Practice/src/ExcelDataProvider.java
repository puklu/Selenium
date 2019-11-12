import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

//	private static Object data[][]=null;
	
    @Test(dataProvider = "testdata1")
	public void test1(String userName, String password) {
    	System.out.println(userName+" | "+password);
		
	}
	
	
	
	
	@DataProvider(name = "testdata1")
	public static Object[][] getData() throws IOException {
		
        String projectPath = System.getProperty("user.dir");
		
		Object[][] dataReceived = testData(projectPath+"/ExcelFiles/Prac1.xlsx", "Sheet1");
		
		return dataReceived;
	}
	
	public static Object[][] testData(String projectPath, String sheetName) throws IOException {
		DealingWithExcel excel = new DealingWithExcel(projectPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				data[i-1][j]=excel.getCellDataString(i, j);						
			}
		}		
		return data;		
	}
}

