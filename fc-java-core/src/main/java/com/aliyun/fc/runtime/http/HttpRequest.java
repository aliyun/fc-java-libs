package com.aliyun.fc.runtime.http;

import java.io.InputStream;
import java.util.Iterator;

public interface HttpRequest {

    String getHeader(String header);

    Iterator<String> getHeaderNames();

    String getParameter(String parameter);

    Iterator<String> getParameterNames();

    String getMethod();

    String getPath();

    InputStream getInputStream();
}
