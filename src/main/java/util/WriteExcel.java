package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	
    
    
    
    
    
    
    
    /*public static void setExcelFile(String Path, String SheetName) throws Exception {
        try {
            // Open the Excel File
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            ExcelWbook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWbook.getSheet(SheetName);
        } catch (Exception e) {
            throw (e);
        }
    }
	
		
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
        try {
        	 ExcelWbook = new XSSFWorkbook("E:\\\\office software\\\\Hackaton SemiColon\\\\InputSemicolon.xlsx");
             ExcelWSheet = ExcelWbook.getSheetAt(1);
            Row = ExcelWSheet.getRow(RowNum);
            Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (Cell == null) {
                Cell = Row.createCell(ColNum);
                
                Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream("E:\\office software\\Hackaton SemiColon\\InputSemicolon.xlsx");
            ExcelWbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            baseUi.reportFail(e.getMessage());
            throw (e);
        }*/
        


	/*wb= new XSSFWorkbook("E:\\\\office software\\\\Hackaton SemiColon\\\\TeamAssign.xlsx");
    sheet = wb.getSheetAt(sheetno);
     sheet.getRow(row).createCell(col).setCellValue(value);
         
 
//To write into Excel File
FileOutputStream outputStream = new FileOutputStream("E:\\office software\\Hackaton SemiColon\\TeamAssign.xlsx");
wb.write(outputStream);

outputStream.close();
    
}*/

	/*public static void setCellData(String Value,int r,int c) throws Exception {
	
	
	  FileInputStream fis=new FileInputStream("E:\\office software\\Hackaton SemiColon\\Trial.xlsx");
	    try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			//XSSFSheet sh= wb.createSheet("abcd");
			XSSFSheet sh = wb.getSheetAt(0);
			XSSFRow row=sh.createRow(r);
			XSSFCell cell= row.createCell(c);

			//cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(Value);
           // fis.close();
            FileOutputStream fos=new FileOutputStream("E:\\office software\\Hackaton SemiColon\\Trail.xlsx");
			wb.write(fos);
			fos.close();
		}

	    System.out.println("Excel File Written successfully");
}   */
	
	
	
	
	
	
	
	public static File file;
	public static FileInputStream work_file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static FileOutputStream result_file;
	
	public static void consoledata(String filePath, String[] data) {
		try {
			file = new File(filePath);
			work_file = new FileInputStream(file);
			workbook = new XSSFWorkbook(work_file);
			worksheet = workbook.getSheetAt(1);//"Insurance");
			XSSFRow row = worksheet.getRow(worksheet.getLastRowNum());
			int rowCount = data.length;
			for (int i = 0; i < rowCount; i++) {
				row = worksheet.createRow(i + 1);
				row.createCell(0).setCellValue(data[i]);
			}
			work_file.close();
			result_file = new FileOutputStream(file);
			workbook.write(result_file);
			result_file.close();
		} catch (FileNotFoundException e) {
			System.out.println("The requested file could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The output operation could not succeed");
			e.printStackTrace();
		}
	}

	public static void carInsurance(String filePath, String data) {
		try {
			file = new File(filePath);
			work_file = new FileInputStream(file);
			workbook = new XSSFWorkbook(work_file);
			worksheet = workbook.getSheetAt(1);//"Insurance");
			//XSSFRow row = worksheet.getRow(worksheet.getLastRowNum());
			
		
				worksheet.createRow(10).createCell(0).setCellValue("Car Insurance Error Message");
				worksheet.createRow(11).createCell(0).setCellValue(data);
			
			work_file.close();
			result_file = new FileOutputStream(file);
			workbook.write(result_file);
			result_file.close();
		} catch (FileNotFoundException e) {
			System.out.println("The requested file could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The output operation could not succeed");
			e.printStackTrace();
		}
	}
	


	
	public static void Healthinsurdata(String filePath, String[] data) {
		try {
			file = new File(filePath);
			work_file = new FileInputStream(file);
			workbook = new XSSFWorkbook(work_file);
			worksheet = workbook.getSheetAt(2);//"Insurance");
			XSSFRow row = worksheet.getRow(worksheet.getLastRowNum());
			int rowCount = data.length;
			for (int j = 0; j < rowCount; j++) {
				row = worksheet.createRow(j + 1);
				row.createCell(0).setCellValue(data[j]);
			}
			work_file.close();
			result_file = new FileOutputStream(file);
			workbook.write(result_file);
			result_file.close();
		} catch (FileNotFoundException e) {
			System.out.println("The requested file could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The output operation could not succeed");
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	public static void passtest(String value,int r,int c)
	{
		try {
			file = new File("./src\\test\\resources\\ExcelData\\OutputData.xlsx");
			work_file = new FileInputStream(file);
			workbook = new XSSFWorkbook(work_file);
			worksheet = workbook.getSheetAt(0);//"TestCaseStatus");
			XSSFRow row = worksheet.getRow(worksheet.getLastRowNum());
			
				row = worksheet.getRow(r);
				row.createCell(c).setCellValue(value);
			work_file.close();
			result_file = new FileOutputStream(file);
			workbook.write(result_file);
			result_file.close();
		} catch (FileNotFoundException e) {
			System.out.println("The requested file could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The output operation could not succeed");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void passval(String value1,String value2)
	{
		try {
			file = new File("./src\\test\\resources\\ExcelData\\OutputData.xlsx");
			work_file = new FileInputStream(file);
			workbook = new XSSFWorkbook(work_file);
			worksheet = workbook.getSheetAt(0);//"TestCaseStatus");
			XSSFRow row = worksheet.getRow(worksheet.getLastRowNum());
			
			for(int i=1;i<5;i=i++) {
			row = worksheet.createRow(i);
				row.createCell(1).setCellValue(value1);
				for(int j=1;j<=5;j=j++) {
					row = worksheet.createRow(i+1);
					row.createCell(2).setCellValue(value2);
				}
			}
			work_file.close();
			result_file = new FileOutputStream(file);
			workbook.write(result_file);
			result_file.close();
		} catch (FileNotFoundException e) {
			System.out.println("The requested file could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The output operation could not succeed");
			e.printStackTrace();
		}
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
