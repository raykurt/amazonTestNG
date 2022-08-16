package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Read_Excel {

    @Test
    public void readExcel() throws IOException {
        String path = "./src/test/java/resources/Capitals.xlsx";
        // Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
        // Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // Open the first worksheet
        Sheet sheet1 = workbook.getSheetAt(0);
        // Go to first row
        Row row1 = sheet1.getRow(0);

        // Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);
        // Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2);
        // Go to 2nd row first cell  and assert if the data equal to USA
        String row2Cell1 = sheet1.getRow(1).getCell(0).toString();
        // Go to 3rd row 2nd cell-chain the row and cell
        String row3Cell2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(row3Cell2);

        // Find the number of row
        int lastRowNumber = sheet1.getLastRowNum()+1; // Beginning index 0 ==> +1 use
        System.out.println(lastRowNumber);
        // Find the number of used row
        int numberOfRowUsed = sheet1.getPhysicalNumberOfRows(); // Beginning index 1 ==> not +1 use
        System.out.println(numberOfRowUsed);

        // Print country, capitol key value pairs as map object
        Map<String, String> countryCapitals = new HashMap<>();
        for(int rowNumber =1; rowNumber<lastRowNumber; rowNumber++){
            String countries = sheet1.getRow(rowNumber).getCell(0).toString();
            String capitals = sheet1.getRow(rowNumber).getCell(1).toString();

            countryCapitals.put(countries,capitals);
        }
        System.out.println(countryCapitals);
    }

//    COUNTRY	CAPITAL	POPULATION
//    USA	D.C
//    France	Paris
//    England	London
//    Turkey	Ankara
//    Greece	Athens
//    Italy	Rome
//    Canada	Ottowa
//    Germany	Berlin
//    Japan	Tokya
//    Norway	Oslo

}
