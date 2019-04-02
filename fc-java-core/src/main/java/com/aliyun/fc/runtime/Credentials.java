package com.aliyun.fc.runtime;

/**
 * This provides the information related to the credentials of the execution role.
 */
public interface Credentials {

    /**
     * Gets the access key ID of the execution role.
     * 
     * @return The access key
     */
    public String getAccessKeyId();

    /**
     * Gets the access key of the execution role.
     * 
     * @return The access secret
     */
    public String getAccessKeySecret();

    /**
     * Gets the security token of the execution role.
     * 
     * @return The security token
     */
    public String getSecurityToken();
}
