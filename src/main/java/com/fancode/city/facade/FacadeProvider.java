package com.fancode.city.facade;

import com.fancode.city.builder.RequestBuilderProvider;
import com.fancode.city.facade.fancode.FancodeFacade;

public class FacadeProvider {
    private static FacadeProvider facadeProviderInstance;

    private RequestBuilderProvider requestBuilderProvider;

    private FancodeFacade fancodeFacade;

    public static FacadeProvider getInstance() {
        if (facadeProviderInstance == null) {
            facadeProviderInstance = new FacadeProvider();
        }
        return facadeProviderInstance;
    }

    public void setRequestBuilderProvider(RequestBuilderProvider requestBuilderProvider) {
        this.requestBuilderProvider = requestBuilderProvider;
    }

    public FancodeFacade getFancodeFacade() {
        if (fancodeFacade == null) {
            fancodeFacade = new FancodeFacade(facadeProviderInstance, requestBuilderProvider);
        }
        return fancodeFacade;
    }

    public void flush() {
        facadeProviderInstance = null;
    }
}
