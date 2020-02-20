package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
	
	Workbook wb;
	public  ExcelFileUtil() throws IOException{
		FileInputStream fi=new FileInputStream("D:\\Selenium_Prathyusha\\SADataDrivenFramework\\TestInput\\supplier.xlsx");
		wb=new XSSFWorkbook(fi);		
	}
	public int rowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}
	public int colCount(String sheetname)
	{
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();
	}
	public String getData(String sheetname,int row, int col)
	{
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC){
		 int celldata = (int)wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
		data=String.valueOf(celldata);
	}else
		{
			data=wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		}
		return data;
		
	}
	public void setData(String sheetname, int row,int col,String status){
		Cell cell=wb.getSheet(sheetname).getRow(row).getCell(col);
		cell.setCellValue(status);
		if(status.equalsIgnoreCase("pass")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
		}else if(status.equalsIgnoreCase("fail")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
		}else if(status.equalsIgnoreCase("NE")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
		}
	}

}

