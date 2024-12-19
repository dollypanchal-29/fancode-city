package com.fancode.city.tests;

import com.fancode.BaseTest;
import com.fancode.city.contants.GroupConstants;
import com.fancode.city.dataProviders.FancodeCityDP;
import com.fancode.city.facade.fancode.FancodeFacade;
import com.fancode.city.validators.FancodeValidators;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FancodeCityTests extends BaseTest {
    private FancodeFacade fancodeFacade;
    private FancodeValidators fancodeValidators;

    @BeforeMethod(alwaysRun = true)
    public void setFancodeImpl() {
        fancodeFacade = facadeProvider.getFancodeFacade();
        fancodeValidators = validatorProvider.getFancodeValidators();
    }

    @Test(description = "Check if all the users of fancode has more than 50% task completion percentage",
    groups = {GroupConstants.COMMON.SANITY, GroupConstants.SERVICE.FANCODE}, dataProviderClass = FancodeCityDP.class, dataProvider = "fancodeThresholdDP")
    public void test_fancode_citizens(long taskCompletionThreshold) {

        fancodeFacade.getFancodeUsers();

        fancodeFacade.getToDoTasks();

        fancodeValidators.validateUsersTaskCompletion(taskCompletionThreshold);
    }
}
