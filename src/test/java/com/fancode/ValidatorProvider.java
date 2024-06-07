package com.fancode;

import com.fancode.city.facade.FacadeProvider;
import com.fancode.city.validators.FancodeValidators;

public class ValidatorProvider {
    private static ValidatorProvider validatorProviderInstance;

    private FacadeProvider facadeProvider;

    private FancodeValidators fancodeValidators;

    public synchronized static ValidatorProvider getInstance() {
        if (validatorProviderInstance == null) {
            validatorProviderInstance = new ValidatorProvider();
        }

        return validatorProviderInstance;
    }

    public void setFacadeProvider(FacadeProvider facadeProvider) {
        this.facadeProvider = facadeProvider;
    }

    public FancodeValidators getFancodeValidators() {
        if (fancodeValidators == null) {
            fancodeValidators = new FancodeValidators(facadeProvider);
        }
        return fancodeValidators;
    }

    public void flush() {
        validatorProviderInstance = null;
    }
}
