package com.fancode.city.builder;

public class RequestBuilderProvider {
    private static RequestBuilderProvider requestBuilderProviderInstance;

    public synchronized static RequestBuilderProvider getInstance() {
        if (requestBuilderProviderInstance == null) {
            requestBuilderProviderInstance = new RequestBuilderProvider();
        }
        return requestBuilderProviderInstance;
    }

    public void flush() {
        requestBuilderProviderInstance = null;
    }
}
