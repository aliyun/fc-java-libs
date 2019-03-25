package com.aliyun.fc.runtime;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This is aliyun function compute http trigger entrance interface.
 *
 */
public interface HttpRequestHandler {
    /**
     * The entrance function of fc http trigger 
     * @param request The servlet request
     * @param response The servlet response
     * @param context The fc context
     * @throws IOException If IO exception happened
     * @throws ServletException If servlet exception happened
     */
    public void handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) throws IOException, ServletException;
}
