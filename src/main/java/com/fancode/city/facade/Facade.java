package com.fancode.city.facade;

import com.fancode.city.builder.RequestBuilderProvider;

public class Facade {

    protected RequestBuilderProvider requestBuilderProvider;
    protected FacadeProvider facadeProvider;

    public Facade(FacadeProvider facadeProvider, RequestBuilderProvider requestBuilderProvider) {
        this.facadeProvider = facadeProvider;
        this.requestBuilderProvider = requestBuilderProvider;
    }
}
