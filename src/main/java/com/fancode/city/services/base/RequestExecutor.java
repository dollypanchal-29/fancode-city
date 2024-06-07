package com.fancode.city.services.base;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class RequestExecutor {

    public Response executeRequest(String baseUri, EndPointEntity endPointEntity) {
        Response response = given().noFilters()
                .baseUri(baseUri)
                .log().all()
                .request(endPointEntity.getHttpMethod().name(), endPointEntity.getEndPoint());

        logResponse(response.asString());

        return response;
    }

    private void logResponse(String responseString) {
        System.out.println("\n\nRESPONSE : \n" + responseString);
    }
}
