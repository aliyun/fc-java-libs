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
     * 
     * @return The request id
     */
    public String getRequestId();

    /**
     * Gets the credentials of the execution role
     * 
     * @return The request Credentials
     */
    public Credentials getExecutionCredentials();

    /**
     * Gets the function related parameters
     * 
     * @return The request function params
     */
    public FunctionParam getFunctionParam();

    /**
     * Gets the service related parameters
     * 
     * @return The request service info
     */
    public Service getService();

    /**
     * Gets the function compute logger instance associated with the context object
     * 
     * @return The fc logger
     */
    public FunctionComputeLogger getLogger();

    /**
     * Gets the function compute opentracing instance associated with the context object
     * 
     * @return The fc tracing
     */
    public OpenTracing getTracing();

     /**
     * Gets the function compute retry count associated with the context object
     * 
     * @return The retry count
     */
    public int getRetryCount();
}


