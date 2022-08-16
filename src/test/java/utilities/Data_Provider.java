package utilities;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Data_Provider {

    @DataProvider(name = "employeeInfo")
    public Object [][] getData(){
        Object [][] employeeCredentials = {
                {"gino.wintheiser","%B6B*q1!TH"},
                {"dallas.batz","dOWjuXz8*es6"},
                {"leonel.skiles","x3uvY0f8hw1T"}
        };
        return employeeCredentials;
    }

    @DataProvider
    public Object [][] getDataCapitals(){
        Object [][] employeeCredentials = {
                {"Germany","Berlin"},
                {"France","Paris"},
                {"Turkey","Ankara"},
                {"USA","Washington"}
        };
        return employeeCredentials;
    }

    @Test(dataProvider = "employeeInfo")
    public void getInfo(String userName, String password){
        System.out.println(userName + "  |  " + password);
    }

    @Test(dataProvider = "getDataCapitals")
    public void getInfoCapitals(String country, String capital){
        System.out.println(country + "  |  " + capital);
    }


//    @DataProvider (name = "employeeInfo")
//    public Object [][] getData(){
//        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//        String sheetName="employee_login_info";
//        excelUtil = new ExcelUtil(path,sheetName);
//        Object [][]  employeeCredentials = excelUtil.getDataArrayWithoutFirstRow();
//        return employeeCredentials;

//    @Test(dataProvider = "employeeInfo")
//    public void employeeLogin(String username, String password) throws InterruptedException {
//        System.out.println(username);
//        System.out.println(password);
//    }


}
