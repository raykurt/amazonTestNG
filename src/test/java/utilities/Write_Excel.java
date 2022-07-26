package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write_Excel {

    @Test
    public void writeExcel() throws IOException {

        // Store the path of the file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";
        // Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // Open the first worksheet
        Sheet sheet1 = workbook.getSheetAt(0);
        // Go to the first row
        Row row1 = sheet1.getRow(0);
        // Create a cell on the 3rd column (2nd index) on the first row
        Cell row1Cell3 = row1.createCell(3);
        // Write “POPULATION” on that cell
        row1Cell3.setCellValue("Testt");
        // Create a cell on the 2nd row 3rd cell(index2), and write 150000
        // Create a cell on the 3rd row 3rd cell(index2), and write 250000
        // Create a cell on the 4th row 3rd cell(index2), and write 54000
        // Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        // Close the file
        // Close the workbook
    }
}
