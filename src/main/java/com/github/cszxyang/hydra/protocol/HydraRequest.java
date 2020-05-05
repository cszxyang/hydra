package com.github.cszxyang.hydra.protocol;

import lombok.Builder;
import lombok.Data;

/**
 * Extensible RPC message
 *  |- header
 *      - magic
 *      - messageSize
 *      - headerSize
 *      - version
 *      - messageType
 *      - serializationType
 *      - requestId
 *      - extend
 *  |- payload
 *      - className
 *      - methodName
 *      - parameterTypes
 *      - parameters
 *
 * @author cszxyang
 * @since 2020-04-17
 */
@Data
public class HydraRequest {

    /** request header **/
    private Header header;
    /** request payload, contains key information about the interface being invoked **/
    private Payload payload;

    @Builder
    public HydraRequest(String requestId, String className, String methodName,
                        Class<?>[] parameterTypes, Object[] parameters) {
        this.header = new Header(requestId);
        this.payload = new Payload(className, methodName, parameterTypes, parameters);
    }

    @Data
    public static class Header {
        /** magic code,                         16 bits **/
        private int magic = 0xcafebabe;
        /** size of request message,            32 bits **/
        private int messageSize;
        /** size of request header,             16 bits **/
        private int headerSize;
        /** version of protocol,                8 bits **/
        private byte version;
        /** type of the message,                8 bits **/
        private byte messageType;
        /** way to (de)serialize the message,   8 bits **/
        private byte serializationType;
        /** request id,                         64 bits **/
        private String requestId;
        /** the extended portion of the message whose length is variable **/
        private Object extend;

        public Header() {}

        public Header(String requestId) {
            this.requestId = requestId;
        }
    }

    @Data
    public static class Payload {
        /** the interface name of the remote call **/
        private String className;
        /** the method name of the remote call **/
        private String methodName;
        /** the parameter type of the method being called **/
        private Class<?>[] parameterTypes;
        /** the parameters of the method being called **/
        private Object[] parameters;

        public Payload() {}

        public Payload(String className, String methodName,
                       Class<?>[] parameterTypes, Object[] parameters) {
            this.className = className;
            this.methodName = methodName;
            this.parameterTypes = parameterTypes;
            this.parameters = parameters;
        }
    }
}
