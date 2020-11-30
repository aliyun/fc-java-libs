package com.aliyun.fc.runtime;

import java.io.IOException;

/**
 * This is the interface for the preStop operation
 */
public interface PreStopHandler {

    /**
     * The interface to handle a function compute preStop request
     *
     * @param context The function compute preStop environment context object.
     * @throws IOException IOException during I/O handling
     */
    void preStop(Context context) throws IOException;
}
