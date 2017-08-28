package com.aliyun.fc.runtime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This is the interface for any none event based function handler
 */
public interface StreamRequestHandler {

    /**
     * The interface to handle a function compute invoke request
     *
     * @param input The function compute input data wrapped in a stream
     * @param output The function compute output data wrapped in a stream
     * @param context The function compute execution environment context object.
     * @throws IOException IOException during I/O handling
     */
    void handleRequest(InputStream input, OutputStream output, Context context) throws IOException;
}