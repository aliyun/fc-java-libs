package com.aliyun.fc.runtime;

import java.io.IOException;

/**
 * This is the interface for the initialization operation
 */
public interface FunctionInitializer {

    /**
     * The interface to handle a function compute initialize request
     *
     * @param context The function compute initialize environment context object.
     * @throws IOException IOException during I/O handling
     */
    void initialize(Context context) throws IOException;
}