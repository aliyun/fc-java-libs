package com.aliyun.fc.runtime.event;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Aliyun Function Compute pojo response type.
 * For response to ApiGateway.
 * 
 * @author santi
 *
 */
public class ApiGatewayResponseEvent {
    @JsonProperty("headers")
    public Map<String, String> headers;
    
    @JsonProperty("statusCode")
    public int statusCode;
    
    @JsonProperty("body")
    public String body;
    
    @JsonProperty("isBase64Encoded")
    public boolean isBase64Encoded;

    @Override
    public String toString() {
        return "ApiGatewayResponseEvent [headers=" + headers + ", statusCode=" + statusCode + ", body=" + body
                + ", isBase64Encoded=" + isBase64Encoded + "]";
    }
}
