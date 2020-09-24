package com.aliyun.fc.runtime;

import java.util.Map;

/**
 * This provides the params related to openTracing.
 */
public interface OpenTracing {

    /**
     * Gets span context of tracing.
     *
     * @return The span context
     */
    public String getSpanContext();

    /**
     * Gets the span context baggages of tracing.
     *
     * @return The span baggages
     */
    public Map<String, String> getSpanBaggages();

    /**
     * Gets the jaeger endpoint.
     *
     * @return The jaeger endpoint
     */
    public String getJaegerEndpoint();
}
