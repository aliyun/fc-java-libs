package com.aliyun.fc.runtime.event;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class OSSEvent {

    public final Event events[];

    @JsonCreator
    public OSSEvent(@JsonProperty("events") Event[] events) {
        this.events = events;
    }

    public static final class Event {

        public final String eventName;
        public final String eventSource;
        public final String eventTime;
        public final String eventVersion;
        public final Oss oss;
        public final String region;
        public final RequestParameters requestParameters;
        public final ResponseElements responseElements;
        public final UserIdentity userIdentity;

        @JsonCreator
        public Event(@JsonProperty("eventName") String eventName,
                     @JsonProperty("eventSource") String eventSource,
                     @JsonProperty("eventTime") String eventTime,
                     @JsonProperty("eventVersion") String eventVersion,
                     @JsonProperty("oss") Oss oss,
                     @JsonProperty("region") String region,
                     @JsonProperty("requestParameters") RequestParameters requestParameters,
                     @JsonProperty("responseElements") ResponseElements responseElements,
                     @JsonProperty("userIdentity") UserIdentity userIdentity) {
            this.eventName = eventName;
            this.eventSource = eventSource;
            this.eventTime = eventTime;
            this.eventVersion = eventVersion;
            this.oss = oss;
            this.region = region;
            this.requestParameters = requestParameters;
            this.responseElements = responseElements;
            this.userIdentity = userIdentity;
        }

        public static final class Oss {

            public final Bucket bucket;
            public final Object object;
            public final String ossSchemaVersion;
            public final String ruleId;

            @JsonCreator
            public Oss(@JsonProperty("bucket") Bucket bucket,
                       @JsonProperty("object") Object object,
                       @JsonProperty("ossSchemaVersion") String ossSchemaVersion,
                       @JsonProperty("ruleId") String ruleId) {
                this.bucket = bucket;
                this.object = object;
                this.ossSchemaVersion = ossSchemaVersion;
                this.ruleId = ruleId;
            }

            public static final class Bucket {

                public final String arn;
                public final String name;
                public final String ownerIdentity;
                public final String virtualBucket;

                @JsonCreator
                public Bucket(@JsonProperty("arn") String arn,
                              @JsonProperty("name") String name,
                              @JsonProperty("ownerIdentity") String ownerIdentity,
                              @JsonProperty("virtualBucket") String virtualBucket) {
                    this.arn = arn;
                    this.name = name;
                    this.ownerIdentity = ownerIdentity;
                    this.virtualBucket = virtualBucket;
                }
            }

            public static final class Object {

                public final long deltaSize;
                public final String eTag;
                public final String key;
                public final long size;
                public final long position;
                public final long readFrom;
                public final long readTo;
                public final ObjectMeta objectMeta;

                @JsonCreator
                public Object(@JsonProperty("deltaSize") long deltaSize,
                              @JsonProperty("eTag") String eTag,
                              @JsonProperty("key") String key,
                              @JsonProperty("size") long size,
                              @JsonProperty("position") long position,
                              @JsonProperty("readFrom") long readFrom,
                              @JsonProperty("readTo") long readTo,
                              @JsonProperty("objectMeta") ObjectMeta objectMeta) {
                    this.deltaSize = deltaSize;
                    this.eTag = eTag;
                    this.key = key;
                    this.size = size;
                    this.position = position;
                    this.readFrom = readFrom;
                    this.readTo = readTo;
                    this.objectMeta = objectMeta;
                }

                public static final class ObjectMeta {
                    public final String mimeType;
                    public final String cacheControl;
                    public final String contentEncoding;
                    public final String contentDisposition;
                    public final String expires;
                    public final String contentLanguage;
                    public final String accessControlAllowOrigin;
                    public final Map<String, String> userMeta;
                    public final Map<String, String> persistentMeta;

                    @JsonCreator
                    public ObjectMeta(@JsonProperty("mimeType") String mimeType,
                                      @JsonProperty("cacheControl") String cacheControl,
                                      @JsonProperty("contentEncoding") String contentEncoding,
                                      @JsonProperty("contentDisposition") String contentDisposition,
                                      @JsonProperty("expires") String expires,
                                      @JsonProperty("contentLanguage") String contentLanguage,
                                      @JsonProperty("accessControlAllowOrigin") String accessControlAllowOrigin,
                                      @JsonProperty("userMeta") Map<String, String>  userMeta,
                                      @JsonProperty("persistentMeta") Map<String, String>  persistentMeta) {
                        this.mimeType = mimeType;
                        this.cacheControl = cacheControl;
                        this.contentEncoding = contentEncoding;
                        this.contentDisposition = contentDisposition;
                        this.expires = expires;
                        this.contentLanguage = contentLanguage;
                        this.accessControlAllowOrigin = accessControlAllowOrigin;
                        this.userMeta = userMeta;
                        this.persistentMeta = persistentMeta;
                    }
                }
            }
        }

        public static final class RequestParameters {

            public final String sourceIPAddress;

            @JsonCreator
            public RequestParameters(@JsonProperty("sourceIPAddress") String sourceIPAddress) {
                this.sourceIPAddress = sourceIPAddress;
            }
        }

        public static final class ResponseElements {

            public final String requestId;

            @JsonCreator
            public ResponseElements(@JsonProperty("requestId") String requestId) {
                this.requestId = requestId;
            }
        }

        public static final class UserIdentity {

            public final String principalId;

            @JsonCreator
            public UserIdentity(@JsonProperty("principalId") String principalId) {
                this.principalId = principalId;
            }
        }
    }
}