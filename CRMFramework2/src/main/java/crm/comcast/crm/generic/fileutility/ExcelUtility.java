package crm.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int celNum ) throws Throwable 
	{
		FileInputStream fis1 = new FileInputStream("D:\\TekPyramid\\\\commondata1 (4).xlsx");
		 Workbook wb=WorkbookFactory.create(fis1);
		 wb.close();
		  String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		  return data;
		 
	}
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("D:\\TekPyramid\\\\commondata1 (4).xlsx");
		 Workbook wb=WorkbookFactory.create(fis1);
	int rowCount=wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;

	}
	public void setDataInToExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("D:\\TekPyramid\\\\commondata1 (4).xlsx");
		 Workbook wb=WorkbookFactory.create(fis1);
		 wb.getSheet(sheetName).getRow(rowNum).getCell(celNum);
		 FileOutputStream fos=new FileOutputStream("D:\\\\TekPyramid\\\\\\commondata1 (4).xlsx");
         wb.write(fos);
         wb.close();
}

}
