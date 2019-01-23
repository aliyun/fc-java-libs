package com.aliyun.fc.runtime.event;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * Aliyun Function Compute pojo request type.
 * For parse event input from ApiGateway trigger.
 * 
 * @author santi
 *
 */

public class ApiGatewayRequestEvent {
    @JsonProperty("path")
    public String path;
    
    @JsonProperty("httpMethod")
    public String httpMethod;
    
    @JsonProperty("headers")
    public Map<String, String> headers;
    
    @JsonProperty("queryParameters")
    public Map<String, String> queryParameters;
    
    @JsonProperty("pathParameters")
    public Map<String, String> pathParameters;
    
    @JsonProperty("body")
    public String body;
    
    @JsonProperty("isBase64Encoded")
    public boolean isBase64Encoded;

    @Override
    public String toString() {
        return "ApiGatewayRequestEvent [path=" + path + ", httpMethod=" + httpMethod + ", headers=" + headers
                + ", queryParameters=" + queryParameters + ", pathParameters=" + pathParameters + ", body=" + body
                + ", isBase64Encoded=" + isBase64Encoded + "]";
    }
}
