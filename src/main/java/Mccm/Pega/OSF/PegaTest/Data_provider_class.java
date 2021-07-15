package Mccm.Pega.OSF.PegaTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.annotations.DataProvider;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.excel.utility.Excel_Reader;

public class Data_provider_class extends TestBase{
	
	public static String ExcelFilePath;
	DataFormatter formatter = new DataFormatter();


	public Object[][] testData() throws Exception {
				

		Excel_Reader obj = new Excel_Reader(ExcelFilePath + "/UseCaseConfigFile/TestData/OSF_Error_Scenarios.xlsx");

		obj.getSheet("Capture_response_error_data");
		int rowcount1 = obj.getrowsnum("Capture_response_error_data");

		System.out.println(rowcount1);

		XSSFRow row = obj.getfirstrow("Capture_response_error_data");

		int col = row.getLastCellNum();

		System.out.println(col);

		Object excelData[][] = new Object[rowcount1 - 1][col];

		for (int i = 0; i < rowcount1 - 1; i++) {

			row = obj.getfirstrow1("Capture_response_error_data", i);

			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				excelData[i][j] = formatter.formatCellValue(cell);
				

			}

		}
		return excelData;

	}
	
	
	public Object[][] testData1() throws Exception {
		

		Excel_Reader obj1 = new Excel_Reader(ExcelFilePath + "/UseCaseConfigFile/TestData/OSF_Error_Scenarios.xlsx");

		obj1.getSheet("ProcessFeedback_error_data");
		int rowcount1 = obj1.getrowsnum("ProcessFeedback_error_data");

		System.out.println(rowcount1);

		XSSFRow row = obj1.getfirstrow("ProcessFeedback_error_data");

		int col = row.getLastCellNum();

		System.out.println(col);

		Object excelData[][] = new Object[rowcount1 - 1][col];

		for (int i = 0; i < rowcount1 - 1; i++) {

			row = obj1.getfirstrow1("ProcessFeedback_error_data", i);

			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				excelData[i][j] = formatter.formatCellValue(cell);
				

			}

		}
		return excelData;


	}
	
    public Object[][] testData2() throws Exception {
		

    	Excel_Reader obj = new Excel_Reader(ExcelFilePath + "/UseCaseConfigFile/TestData/OSF_Error_Scenarios.xlsx");

		obj.getSheet("GetNBA_error_data");
		int rowcount1 = obj.getrowsnum("GetNBA_error_data");

		System.out.println(rowcount1);

		XSSFRow row = obj.getfirstrow("GetNBA_error_data");

		int col = row.getLastCellNum();

		System.out.println(col);

		Object excelData[][] = new Object[rowcount1 - 1][col];

		for (int i = 0; i < rowcount1 - 1; i++) {

			row = obj.getfirstrow1("GetNBA_error_data", i);

			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				excelData[i][j] = formatter.formatCellValue(cell);
				

			}

		}
		return excelData;

	}

    @DataProvider(name = "invalidheader_data")
    public Object[][] testData_invalidheaders() throws Exception {
		

    	Excel_Reader obj = new Excel_Reader(ExcelFilePath + "/UseCaseConfigFile/TestData/OSF_Error_Scenarios.xlsx");

		obj.getSheet("Data_invalid_headers");
		int rowcount1 = obj.getrowsnum("Data_invalid_headers");

		System.out.println(rowcount1);

		XSSFRow row = obj.getfirstrow("Data_invalid_headers");

		int col = row.getLastCellNum();

		System.out.println(col);

		Object excelData[][] = new Object[rowcount1 - 1][col];

		for (int i = 0; i < rowcount1 - 1; i++) {

			row = obj.getfirstrow1("Data_invalid_headers", i);

			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				excelData[i][j] = formatter.formatCellValue(cell);
				

			}

		}
		return excelData;

	}
    
    
	@DataProvider(name = "exceldata")
	public Object[][] combinedDataProvider() throws Exception {
	    // Using stream to combine the two separate data providers.
	    return Stream.of(testData(), testData1(), testData2())
	                 .flatMap(Arrays::stream)
	                 .toArray(Object[][]::new);
	}
	

	}
	
	
	
	
	

