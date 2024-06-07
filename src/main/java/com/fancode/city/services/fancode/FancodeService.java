package com.fancode.city.services.fancode;

import com.fancode.city.services.base.RequestExecutor;
import io.restassured.response.Response;

public class FancodeService extends FancodeEndpointProvider {
    RequestExecutor requestExecutor;

    public FancodeService() {
        this.requestExecutor = new RequestExecutor();
    }

    public Response getUsers() {
        return requestExecutor.executeRequest(fancodeBaseUri, getUserInfoEndpoint());
    }

    public Response getToDos() {
        return requestExecutor.executeRequest(fancodeBaseUri, getToDoEndpoint());
    }
}
