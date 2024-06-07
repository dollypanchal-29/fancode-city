package com.fancode;

import com.fancode.city.builder.RequestBuilderProvider;
import com.fancode.city.facade.FacadeProvider;
import com.fancode.city.utils.SerialisationUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected FacadeProvider facadeProvider;

    protected ValidatorProvider validatorProvider;

    protected RequestBuilderProvider requestBuilderProvider;

    @BeforeMethod(alwaysRun = true)
    public void setFacadeImpl() {
        facadeProvider = FacadeProvider.getInstance();
        requestBuilderProvider = RequestBuilderProvider.getInstance();
        facadeProvider.setRequestBuilderProvider(requestBuilderProvider);
        validatorProvider = ValidatorProvider.getInstance();
        validatorProvider.setFacadeProvider(facadeProvider);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanFacadeImpl() {
        SerialisationUtil.skipCheckForBadRequest = false;
        SerialisationUtil.skipCheckForInternalServerError = false;
        requestBuilderProvider.flush();
        facadeProvider.flush();
        validatorProvider.flush();
    }

}
