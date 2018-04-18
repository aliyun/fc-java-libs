package com.aliyun.fc.runtime.http;

import java.io.OutputStream;

public interface HttpResponse {

    int getStatus();

    void setStatus(int status);

    void setHeader(String key, String value);

    String getHeader(String key);

    OutputStream getOutputStream();
}
