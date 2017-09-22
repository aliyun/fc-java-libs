package com.aliyun.fc.runtime;

/**
 *
 * The interface for request handlers that implement Alibaba cloud function compute using plain old java objects
 * as input and output.
 *
 * @param <I> The input parameter type
 * @param <O> The output parameter type
 */
public interface PojoRequestHandler<I, O> {
    /**
     * Handles a function compute invoke request
     * Handles a function compute invoke request
     * @param input The function input as a Pojo
     * @param context The function execution environment context object.
     * @throws Exception any checked user exceptions
     * @return The function output as a Pojo
     */
    public O handleRequest(I input, Context context) throws Exception;
}