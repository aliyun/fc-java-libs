package com.aliyun.fc.runtime;

/**
 * This provides the params related to Service.
 */
public interface Service {

    /**
     * Gets name of service.
     *
     * @return The service name
     */
    public String getName();

    /**
     * Gets the log project.
     *
     * @return The log project
     */
    public String getLogProject();

    /**
     * Gets the log store.
     *
     * @return The log store
     */
    public String getLogStore();
    
    /**
     * Gets the qualifier.
     *
     * @return The qualifier
     */
    public String getQualifier();

    /**
     * Gets the version id.
     *
     * @return The version id
     */
    public String getVersionId();

}
