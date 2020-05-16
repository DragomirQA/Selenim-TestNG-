package test.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ReadFakeData {

	public static void main(String[] ar) {
		HSSFWorkbook wb;
		FileInputStream fi;

		try {
			fi = new FileInputStream("testData.xls");
			wb = new HSSFWorkbook(fi);

			Sheet sheet = wb.getSheetAt(0);

			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);

			System.out.println(cell);

			cell = row.getCell(1);
			System.out.println(cell);
			cell = row.getCell(2);
			System.out.println(cell);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getData(int rowNo, int cellNo) throws IOException {
		HSSFWorkbook wb;
		FileInputStream fi;
		fi = new FileInputStream("testData.xls");
		wb = new HSSFWorkbook(fi);
		Sheet sheet = wb.getSheetAt(0);

		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		wb.close();
		return cell.toString();

	}
}
