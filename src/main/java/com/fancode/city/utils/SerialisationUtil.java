package com.fancode.city.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

public class SerialisationUtil {

    public static boolean skipCheckForInternalServerError = false;
    public static boolean skipCheckForBadRequest = false;
    public static ObjectMapper objectMapper;

    public static ObjectMapper getMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();

            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
            objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

            objectMapper.addHandler(new DeserializationProblemHandler() {
                @Override
                public Object handleMissingInstantiator(DeserializationContext ctxt, Class<?> instClass, ValueInstantiator valueInsta, JsonParser p, String msg) throws IOException {
                    return null;
                }
            });
        }

        return objectMapper;
    }

    public static <T> String serialize(T object) {
        try {
            return getMapper().writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(Response response, Class<T> clazz) {
        try {
            checkForBadRequest(response);
            checkForInternalServerError(response);
            return getMapper().readValue(response.asString(), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> deserializeListObject(Response response, Class<T> clazz) {
        try {
            checkForBadRequest(response);
            checkForInternalServerError(response);
            CollectionType typeReference =
                    TypeFactory.defaultInstance().constructCollectionType(List.class, clazz);
            return getMapper().readValue(response.asString(), typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(String content, Class<T> clazz) {
        try {
            return getMapper().readValue(content, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void checkForBadRequest(Response response) {
        if (skipCheckForBadRequest) return;

        if (response.getStatusCode() >= 400 && response.getStatusCode() < 500) {
            throw new RuntimeException("Bad request. \n\nResponse : " + response.getBody().asString() + ".\nStatus code : " + response.getStatusCode());
        }
    }

    private static void checkForInternalServerError(Response response) {
        if (skipCheckForInternalServerError) return;

        if (response.getStatusCode() >= 500 && response.getStatusCode() < 530) {
            throw new RuntimeException("Internal server error. \n\nResponse : " + response.getBody().asString() + ".\nStatus code : " + response.getStatusCode());
        }
    }
}
