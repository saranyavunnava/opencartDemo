package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() {
		String path = ".\\TestData\\TestData.xlsx";
		ExcelUtility xlUtil = new ExcelUtility(path);
		int totalRows = xlUtil.getRowCount();
		int totalCols = xlUtil.cellCount();
		String loginData[][] = new String[totalRows][totalCols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {

				loginData[i - 1][j] = xlUtil.getCellData(i, j);

			}

		}
		return loginData;
	}
	
}