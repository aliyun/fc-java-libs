package com.aliyun.fc.runtime;

import java.io.IOException;

/**
 * This is the interface for the preFreeze operation
 */
public interface PreFreezeHandler {

    /**
     * The interface to handle a function compute preFreeze request
     *
     * @param context The function compute preFreeze environment context object.
     * @throws IOException IOException during I/O handling
     */
    void preFreeze(Context context) throws IOException;
}
