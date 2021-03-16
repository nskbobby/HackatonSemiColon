package util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static XSSFWorkbook wb;

	public static  String findCell(int sheetno,int rowno,int cellno) throws Exception
	{
		 FileInputStream f1=new FileInputStream("./src\\test\\resources\\ExcelData\\InputSemicolon.xlsx");
		 wb = new XSSFWorkbook(f1);
			XSSFSheet ws=wb.getSheetAt(sheetno);
			XSSFCell dataa=ws.getRow(rowno).getCell(cellno);
			String dat=String.valueOf(dataa.getStringCellValue());
			System.out.println(dat);
			wb.close();
			return dat;
			
	}
	public static double findCellNumeric(int sheetno,int rowno,int cellno) throws Exception
	{
		 FileInputStream f1=new FileInputStream("./src\\test\\resources\\ExcelData\\InputSemicolon.xlsx");
		 wb = new XSSFWorkbook(f1);
			XSSFSheet ws=wb.getSheetAt(sheetno);
			XSSFCell dataa=ws.getRow(rowno).getCell(cellno);
			double dat=dataa.getNumericCellValue();
			System.out.println(dat);
			f1.close();
			return dat;
	}


}
