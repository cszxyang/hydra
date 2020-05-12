package com.github.cszxyang.hydra.transport.serialization;

/**
 * define abstract behaviors of Serializer/Deserializer
 *
 * @author cszxyang
 */
public interface Serializer {
    /**
     * transform an object into a byte array
     *
     * @param object the object
     * @param <T>    type of the object
     * @return a byte array
     */
    <T> byte[] serialize(T object);

    /**
     * transform a byte array into an object
     *
     * @param bytes a byte array
     * @param clz   type of the object
     * @param <T>   class info of the object
     * @return deSerialized object
     */
    <T> T deSerialize(byte[] bytes, Class<T> clz);
}