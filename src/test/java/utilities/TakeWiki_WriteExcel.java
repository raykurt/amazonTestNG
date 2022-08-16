package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TakeWiki_WriteExcel {

//    @Test
//    public void wikipediaTable(){
//        driver.get("https://en.wikipedia.org/wiki/List_of_countries_by_GDP_(nominal)");
//        List<WebElement> countries = driver.findElements(By.xpath("//table[2]//tbody//tr//td[1]"));
//        List<WebElement> gdp = driver.findElements(By.xpath("//table[2]//tbody//tr//td[4]"));
//        Map<String, String> countryGDP = new LinkedHashMap<>();
//        for(int i = 0; i<countries.size(); i++){
//            String countryName = countries.get(i).getText();
//            String gdpOfCountries = gdp.get(i).getText();
//            countryGDP.put(countryName,gdpOfCountries);
//            writeToExcel(countryName,gdpOfCountries,i);
//        }
//        System.out.println(countryGDP);
//    }
//    public void  writeToExcel(String a, String b, int c) {
//        try {
//            String path = "./src/test/java/resources/CountryGDP.xlsx";
//            FileInputStream fileInputStream = new FileInputStream(path);
//            Workbook workbook = WorkbookFactory.create(fileInputStream);
//            Sheet sheet = workbook.getSheetAt(0);
//            sheet.createRow(0).createCell(0).setCellValue("County");
//            sheet.getRow(0).createCell(1).setCellValue("GDP");
//            sheet.createRow(c+1).createCell(0).setCellValue(a);
//            sheet.getRow(c+1).createCell(1).setCellValue(b);
//            FileOutputStream fileOutputStream = new FileOutputStream(path);
//            workbook.write(fileOutputStream);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
