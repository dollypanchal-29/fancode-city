package com.fancode.city.dataProviders;

import org.testng.annotations.DataProvider;

public class FancodeCityDP {
    @DataProvider(name = "fancodeThresholdDP")
    public Object[][] fancodeThresholdDP() {
        return new Object[][]{
                {
                    50L
                }
        };
    }
}
