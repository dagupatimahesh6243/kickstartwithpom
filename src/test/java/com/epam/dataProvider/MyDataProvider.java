package com.epam.dataProvider;

import com.epam.util.TestUtil;
import org.testng.annotations.DataProvider;

public class MyDataProvider {
    @DataProvider(name = "CollegesTestData")
    public Object[][] getCollegesTestData() {
        Object data[][]= TestUtil.getTestData("CollegeData");
        return data;
    }
    @DataProvider(name = "CollegesNegativeTestData")
    public Object[][] getCollegesNegativeTestData() {
        Object dataNegative[][]= TestUtil.getTestData("CollegeNegative");
        return dataNegative;
    }
}
