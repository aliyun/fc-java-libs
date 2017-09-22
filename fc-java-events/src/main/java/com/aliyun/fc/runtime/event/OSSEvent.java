package com.aliyun.fc.runtime.event;

public class OSSEvent {

    public OSSEvent.Event events[];

    public static final class Event {

        private String eventName;
        private String eventSource;
        private String eventTime;
        private String eventVersion;
        private OSSEvent.Event.Oss oss;
        private String region;
        private OSSEvent.Event.RequestParameters requestParameters;
        private OSSEvent.Event.ResponseElements responseElements;
        private OSSEvent.Event.UserIdentity userIdentity;

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getEventSource() {
            return eventSource;
        }

        public void setEventSource(String eventSource) {
            this.eventSource = eventSource;
        }

        public String getEventTime() {
            return eventTime;
        }

        public void setEventTime(String eventTime) {
            this.eventTime = eventTime;
        }

        public String getEventVersion() {
            return eventVersion;
        }

        public void setEventVersion(String eventVersion) {
            this.eventVersion = eventVersion;
        }

        public Oss getOss() {
            return oss;
        }

        public void setOss(Oss oss) {
            this.oss = oss;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public RequestParameters getRequestParameters() {
            return requestParameters;
        }

        public void setRequestParameters(
            RequestParameters requestParameters) {
            this.requestParameters = requestParameters;
        }

        public ResponseElements getResponseElements() {
            return responseElements;
        }

        public void setResponseElements(
            ResponseElements responseElements) {
            this.responseElements = responseElements;
        }

        public UserIdentity getUserIdentity() {
            return userIdentity;
        }

        public void setUserIdentity(UserIdentity userIdentity) {
            this.userIdentity = userIdentity;
        }

        public static final class Oss {

            private OSSEvent.Event.Oss.Bucket bucket;
            private OSSEvent.Event.Oss.Object object;
            private String ossSchemaVersion;
            private String ruleId;

            public Bucket getBucket() {
                return bucket;
            }

            public void setBucket(Bucket bucket) {
                this.bucket = bucket;
            }

            public Object getObject() {
                return object;
            }

            public void setObject(Object object) {
                this.object = object;
            }

            public String getOssSchemaVersion() {
                return ossSchemaVersion;
            }

            public void setOssSchemaVersion(String ossSchemaVersion) {
                this.ossSchemaVersion = ossSchemaVersion;
            }

            public String getRuleId() {
                return ruleId;
            }

            public void setRuleId(String ruleId) {
                this.ruleId = ruleId;
            }

            public static final class Bucket {

                private String arn;
                private String name;
                private String ownerIdentity;
                private String virtualBucket;

                public String getArn() {
                    return arn;
                }

                public void setArn(String arn) {
                    this.arn = arn;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getOwnerIdentity() {
                    return ownerIdentity;
                }

                public void setOwnerIdentity(String ownerIdentity) {
                    this.ownerIdentity = ownerIdentity;
                }

                public String getVirtualBucket() {
                    return virtualBucket;
                }

                public void setVirtualBucket(String virtualBucket) {
                    this.virtualBucket = virtualBucket;
                }
            }

            public static final class Object {

                private long deltaSize;
                private String eTag;
                private String key;
                private long size;

                public long getDeltaSize() {
                    return deltaSize;
                }

                public void setDeltaSize(long deltaSize) {
                    this.deltaSize = deltaSize;
                }

                public String geteTag() {
                    return eTag;
                }

                public void seteTag(String eTag) {
                    this.eTag = eTag;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public long getSize() {
                    return size;
                }

                public void setSize(long size) {
                    this.size = size;
                }
            }
        }

        public static final class RequestParameters {

            private String sourceIPAddress;

            public String getSourceIPAddress() {
                return sourceIPAddress;
            }

            public void setSourceIPAddress(String sourceIPAddress) {
                this.sourceIPAddress = sourceIPAddress;
            }
        }

        public static final class ResponseElements {

            private String requestId;

            public String getRequestId() {
                return requestId;
            }

            public void setRequestId(String requestId) {
                this.requestId = requestId;
            }
        }

        public static final class UserIdentity {

            private String principalId;

            public String getPrincipalId() {
                return principalId;
            }

            public void setPrincipalId(String principalId) {
                this.principalId = principalId;
            }
        }
    }
}