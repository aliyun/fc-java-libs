package com.aliyun.fc.runtime;

import java.io.File;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Globals;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;


public class FcAppLoader implements AppLoader {
    // FC context
    private Context context = null;
    private String accessKeyId = null;
    private String accessKeySecret = null;
    
    private String TMP_PATH = "/tmp";   // FC writable path
    private String appFilePath = "";    // App code file path
    private String downloadPath = TMP_PATH;   // App download path
    private String baseDir = TMP_PATH;        // App home path

    // WebApp context
    private org.apache.catalina.Context appContext;
    
    public FcAppLoader() {
    }

    @Override
    public void setFCContext(Context context) {
        this.context = context;
    }
    
    @Override
    public void SetFCContext(String accessKeyId, String accessKeySecret) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    @Override
    public org.apache.catalina.Context getAppContext() {
        return appContext;
    }

    @Override
    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    @Override
    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    @Override
    public void loadCode(String appFilePath) {
        this.appFilePath = appFilePath;
    }

    @Override
    public void loadCodeFromLocalProject(String appFilePath) {
        this.appFilePath = System.getenv("FC_FUNC_CODE_PATH") + File.separator + appFilePath;
    }

    @Override
    public Boolean loadCodeFromOSS(String ossEndPoint, String bucket, String appName) {
        appFilePath = downloadPath + File.separator + appName;
        
        try {
            OSSClient ossClient = null;
            
            if (accessKeyId != null && accessKeySecret != null) {
                // Priority use accessKeyId and accessKeySecret if set
               ossClient = new OSSClient(ossEndPoint, accessKeyId, accessKeySecret); 
            } else {
                // Secondly use FC Context
                Credentials credentials = context.getExecutionCredentials();
                ossClient = new OSSClient(
                        ossEndPoint,
                        credentials.getAccessKeyId(),
                        credentials.getAccessKeySecret(),
                        credentials.getSecurityToken());
            }

            GetObjectRequest request = new GetObjectRequest(bucket, appName);
            ossClient.getObject(request, new File(appFilePath));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean initApp(String userContextPath, ClassLoader appLoader) {
        Tomcat tomcat  = new Tomcat();
        
        // Set work directory
        tomcat.setBaseDir(baseDir);
        
        // Set weapp directory (ROOT .etc.)
        tomcat.getHost().setAppBase(baseDir);
        
        // Load webapp use embedded tomcat
        try {
            TomcatURLStreamHandlerFactory.disable();
            
            appContext = tomcat.addWebapp(userContextPath, appFilePath);
            WebappLoader loader = new WebappLoader(appLoader);
            appContext.setLoader(loader);

            tomcat.getService().init();
            tomcat.getService().start();
        } catch (Exception e) {
            e.printStackTrace();
            appContext = null;
            return false;
        }
        
        // Set all filters in user webapp can be invoked
        FilterMap[] filterMaps = appContext.findFilterMaps();
        for(FilterMap filterMap : filterMaps) {
            filterMap.setDispatcher(DispatcherType.FORWARD.name());
            filterMap.setDispatcher(DispatcherType.INCLUDE.name());
            filterMap.setDispatcher(DispatcherType.REQUEST.name());
            filterMap.setDispatcher(DispatcherType.ERROR.name());
            filterMap.setDispatcher(DispatcherType.ASYNC.name());
        }
        return true;
    }

    @Override
    public void forward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String requestPath = (String) request.getAttribute("FC_REQUEST_PATH");
        String contextPath = appContext.getPath();

        // Remove contextPath from requestPath
        if (StringUtils.isNotEmpty(requestPath) && StringUtils.startsWith(requestPath, contextPath)) {
            requestPath = requestPath.replaceFirst(contextPath, "");
        }
        
        if (StringUtils.isEmpty(requestPath)) requestPath = "/";
        
        RequestDispatcher dispatcher = appContext.getServletContext().getRequestDispatcher(requestPath);
        if (dispatcher == null) {
            throw new Exception("Get request dispatcher failed for path : " + requestPath);
        }
        
        request.setAttribute(Globals.DISPATCHER_TYPE_ATTR, request.getDispatcherType());
        dispatcher.forward(request, response);
    }
}
