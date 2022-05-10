package resources.testdata;

import org.testng.annotations.DataProvider;


public class TestData {

     @DataProvider(name = "credentials")
      public Object[][] getData(){

          Object[][] data = new Object[][]{

                  {"Admin", "admin123"}
          };
          return data;
      }


}
