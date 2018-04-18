package com.aliyun.fc.runtime;

import com.aliyun.fc.runtime.http.HttpRequest;
import com.aliyun.fc.runtime.http.HttpResponse;

import java.io.IOException;

/**
 *
 * The interface for request handlers that implement Alibaba cloud function compute using http trigger
 *
 */
public interface HttpRequestHandler {

    /**
     * Handles a function compute http request
     *
     * @param request The function input as a HttpRequest
     * @param response The function output as a HttpResponse
     * @param context The function execution environment context object.
     */
    void handleRequest(HttpRequest request, HttpResponse response, Context context) throws IOException;
}
