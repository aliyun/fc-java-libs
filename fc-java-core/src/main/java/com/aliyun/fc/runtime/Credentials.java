package com.aliyun.fc.runtime;

/**
 * This provides the information related to the credentials of the execution role.
 */
public interface Credentials {

    /**
     * Gets the access key ID of the execution role.
     */
    public String getAccessKeyId();

    /**
     * Gets the access key of the execution role.
     */
    public String getAccessKeySecret();

    /**
     * Gets the security token of the execution role.
     */
    public String getSecurityToken();
}
