package utilities;

import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Write_Read_Txt_File {

   @Test
   public void writeTxt() throws IOException{

       FileWriter fileWriter = new FileWriter("src/test/resources/testdata/FileName.txt", true);

       BufferedWriter writer = new BufferedWriter(fileWriter);
       writer.append("blablabla"+"\n");

       writer.close();
   }

    @Test
    public void readTxt() throws IOException {

        List<String> list = new ArrayList<>();

        FileReader fileReader = new FileReader("src/test/resources/testdata/FileName.txt");

        BufferedReader br = new BufferedReader(fileReader);

        String line = br.readLine();

        while (line != null) {
            String ssn = line.split(",")[0];
            list.add(ssn);
            line = br.readLine();
        }
    }
}
