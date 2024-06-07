package com.fancode.city.services.base;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EndPointEntity {
    HttpMethod httpMethod;
    String endPoint;
}
