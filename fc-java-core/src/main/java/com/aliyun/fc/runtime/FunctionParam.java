package com.aliyun.fc.runtime;

/**
 * This provides the information related to the invoking function
 */
public interface FunctionParam {

    /**
     * Gets the name of the function being executed.
     */
    public String getFunctionName();

    /**
     * Gets the fully qualified name of the handler being executed.
     */
    public String getFunctionHandler();

    /**
     * Gets the fully qualified name of the initializer being executed.
     * 
     * @return String
     */
    public String getFunctionInitializer();
    
    /**
     * Gets the execution time limit of the function
     */
    public int getExecTimeLimitInMillis();

    /**
     * Gets the maximum memory size configured for the function
     */
    public int getMemoryLimitInMB();

}
