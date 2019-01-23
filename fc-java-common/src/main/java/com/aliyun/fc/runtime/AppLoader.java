package com.aliyun.fc.runtime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * FC Java Http Trigger support traditional web application framework such as Spring, SpringBoot, Struts2. etc.
 * This class used for load webapp
 * @author santi
 *
 */
public interface AppLoader {
    /**
     * Set fc execute credential context
     * @param context Credential context
     */
    public void setFCContext(Context context);
    
    /**
     * Set fc execute ak sk
     * @param accessKeyId The accessKeyId
     * @param accessKeySecret The accessKeySecret
     */
    public void SetFCContext(String accessKeyId, String accessKeySecret);

    /**
     * Get webapp loaded Context
     * @return The webapp context
     */
    public org.apache.catalina.Context getAppContext();

    /**
     * Set download path, for example if your webapp package from oss.
     * Default is /tmp which is only writable directory on FC.
     * Also you can set this to NAS path if you use NAS on FC.
     * @param downloadPath The path to download webapp
     */
    public void setDownloadPath(String downloadPath);

    /**
     * Set base dir of webapp, the inited webapp will then write to this path.
     * Default is /tmp
     * Also you can set this to NAS path
     * @param baseDir The path of webapp home
     */
    public void setBaseDir(String baseDir);

    /**
     * Load webapp code from specified path
     * @param appFilePath The path of app package
     */
    public void loadCode(String appFilePath);

    /**
     * Load webapp code from path relative to user project
     * @param appFilePath The path of app package
     */
    public void loadCodeFromLocalProject(String appFilePath);

    /**
     * Load webapp code from oss
     * @param ossEndPoint oss endpoint
     * @param bucket oss bucket
     * @param appName oss key
     * @return Whether Success
     */
    public Boolean loadCodeFromOSS(String ossEndPoint, String bucket, String appName);

    /**
     * Init Webapp
     * @param userContextPath Web context path:
     *        1. For non custom domain http trigger, something like 2016-08-15/proxy/${serviceName}/${functionName}
     *        2. For custom domain http trigger, according your path mapping settings.
     * @param appLoader Loader for WebApp context
     * @return Whether load success
     */
    public boolean initApp(String userContextPath, ClassLoader appLoader);

    /**
     * Forward request to inited webapp
     * @param request Servlet request
     * @param response Servlet response
     * @throws Exception Raise when something error
     */
    public void forward (HttpServletRequest request, HttpServletResponse response) throws Exception;
}

