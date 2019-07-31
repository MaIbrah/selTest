package pageFactory.dataProvider;

import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviderParameters {


    @DataProvider(name="SearchProvider")
    static public Object[][] getDataProvider(){
        return new Object[][]{
            {"test1","test1"},
            {"test2","test2"},
            {"test2","test2"},
            {"mgr123","mgr!23"}
        };
    }

}
