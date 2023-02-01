package steps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static utilities.DataReader.getJsonDataToMap;

public class test {


    @Test (dataProvider="getData")
    public void dataProviderTest(HashMap<String, String > input) {

        System.out.println(input.get("email"));
        System.out.println(input.get("password"));
        System.out.println(input.get("gender"));



    }

   @DataProvider
    public Object[][] getData() {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/test.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }


}
