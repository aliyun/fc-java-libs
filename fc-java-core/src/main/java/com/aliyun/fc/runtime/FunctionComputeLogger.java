package com.aliyun.fc.runtime;


/**
 * The interface for the alibaba cloud function compute user to log to aliyun's logstore
 *
 * Logging will not be done: <ul> <li> If the container is not configured to log to alibaba
 * cloud logstore. </li> <li> If the role provided to the function does not have sufficient
 * permissions. </li> </ul>
 */
public interface FunctionComputeLogger {

    /**
     * Logs a trace level event to alibaba cloud logstore
     *
     * @param string A string containing the event to log.
     */
    void trace(String string);

    /**
     * Logs a debug level event to alibaba cloud logstore
     *
     * @param string A string containing the event to log.
     */
    void debug(String string);

    /**
     * Logs a info level event to alibaba cloud logstore
     *
     * @param string A string containing the event to log.
     */
    void info(String string);

    /**
     * Logs a warn level event to alibaba cloud logstore
     *
     * @param string A string containing the event to log.
     */
    void warn(String string);

    /**
     * Logs an error level event to alibaba cloud logstore
     *
     * @param string A string containing the event to log.
     */
    void error(String string);

    enum Level {
        TRACE, DEBUG, INFO, WARN, ERROR, FATAL
    }
}
