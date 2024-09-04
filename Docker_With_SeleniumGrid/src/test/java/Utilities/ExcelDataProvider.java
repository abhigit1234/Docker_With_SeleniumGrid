package Utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name = "Reg", parallel = true)
	public Object[][] excel() {

		ReadExcel rc = new ReadExcel("C:\\Users\\abhil\\OneDrive\\Desktop\\test.xlsx");
		int row = rc.getRowCount("Register");
		int col = rc.getCellCount("Register", 1);
		Object[][] data = new Object[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = rc.getCellData("Register", i, j);
			}
		}

		return data;
	}

}
