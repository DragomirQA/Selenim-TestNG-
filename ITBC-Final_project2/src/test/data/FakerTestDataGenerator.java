package test.data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.github.javafaker.Faker;

public class FakerTestDataGenerator {

	public void generateData() {

		Faker f = new Faker();

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		for (int createRow = 0; createRow < 30; createRow++) {
			Row row = sheet.createRow(createRow);
			Cell cell = row.createCell(0);
			String firstName = f.name().firstName();
			cell.setCellValue(firstName);

			cell = row.createCell(1);
			String lastName = f.name().lastName();
			cell.setCellValue(lastName);

			cell = row.createCell(2);
			String email = f.internet().emailAddress();
			cell.setCellValue(email);

			cell = row.createCell(3);
			String password = f.internet().password();
			cell.setCellValue(password);

			String website = f.letterify(email).replace("@", "b") + ".com";
			cell = row.createCell(4);
			cell.setCellValue(website);

			sheet.autoSizeColumn(createRow);

		}
		try {
			FileOutputStream os = new FileOutputStream("testData.xls");
			wb.write(os);

			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());// .printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
