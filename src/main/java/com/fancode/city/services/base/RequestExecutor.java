package com.fancode.city.services.base;

import com.fancode.city.models.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import static com.fancode.city.utils.LoggerUtil.logResponse;
import static io.restassured.RestAssured.given;

@Slf4j
public class RequestExecutor {

    public Response executeRequest(String baseUri, EndPointEntity endPointEntity) {
        return executeRequest(baseUri, endPointEntity, null);
    }

    public Response executeRequest(String baseUri, EndPointEntity endPointEntity, LogConfig logConfig) {
        if (logConfig == null) {
            logConfig = LogConfig.builder()
                    .logRequest(true)
                    .logResponse(true)
                    .build();
        }

        RequestSpecification requestSpecification = given().noFilters()
                .baseUri(baseUri);

        if (logConfig.isLogRequest()) {
            requestSpecification = requestSpecification.log().all();
        }

        Response response = requestSpecification
                .request(endPointEntity.getHttpMethod().name(), endPointEntity.getEndPoint());

        if (logConfig.isLogResponse()) {
            logResponse(response.asString());
        }

        return response;
    }


}
