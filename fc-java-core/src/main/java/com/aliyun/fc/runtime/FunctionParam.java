package com.aliyun.fc.runtime;

/**
 * This provides the information related to the invoking function
 */
public interface FunctionParam {

    /**
     * Gets the name of the function being executed.
     * 
     * @return Function name
     */
    public String getFunctionName();

    /**
     * Gets the fully qualified name of the handler being executed.
     * 
     * @return Function handler
     */
    public String getFunctionHandler();

    /**
     * Gets the fully qualified name of the initializer being executed.
     * 
     * @return Function initializer
     */
    public String getFunctionInitializer();
    
    /**
     * Gets the execution time limit of the function
     *
     *  @return The timeout in MS
     */
    public int getExecTimeLimitInMillis();

    /**
     * Gets the maximum memory size configured for the function
     * 
     * @return The memory limit in MB
     */
    public int getMemoryLimitInMB();

}
