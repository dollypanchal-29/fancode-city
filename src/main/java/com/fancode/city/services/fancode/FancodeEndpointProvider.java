package com.fancode.city.services.fancode;

import com.fancode.city.services.base.EndPointEntity;
import com.fancode.city.services.base.HttpMethod;

public class FancodeEndpointProvider {
    protected final String fancodeBaseUri = "https://jsonplaceholder.typicode.com";

    protected EndPointEntity getUserInfoEndpoint() {
        return EndPointEntity.builder()
                .httpMethod(HttpMethod.GET)
                .endPoint("/users")
                .build();
    }

    protected EndPointEntity getToDoEndpoint() {
        return EndPointEntity.builder()
                .httpMethod(HttpMethod.GET)
                .endPoint("/todos")
                .build();
    }
}
