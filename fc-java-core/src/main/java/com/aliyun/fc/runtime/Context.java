package com.aliyun.fc.runtime;

/**
 * The context object allows you to access useful information available within the alibaba cloud
 * function compute execution environment
 */
public interface Context {

    /**
     * Gets the alibaba cloud function compute request ID associated with the request. <p> This is
     * the same ID returned to the client that called invoke(). This ID is reused for retries on the
     * same request. </p>
     */
    public String getRequestId();

    /**
     * Gets the credentials of the execution role
     */
    public Credentials getExecutionCredentials();

    /**
     * Gets the function related parameters
     */
    public FunctionParam getFunctionParam();

    /**
     * Gets the function compute logger instance associated with the context object
     */
    public FunctionComputeLogger getLogger();
}


