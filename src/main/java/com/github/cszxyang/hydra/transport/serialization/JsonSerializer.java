package com.github.cszxyang.hydra.transport.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * converting data format with JSON
 *
 * @author cszxyang
 */
public class JsonSerializer implements Serializer {

    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public <T> byte[] serialize(T obj) {
        try {
            return objectMapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deSerialize(byte[] bytes, Class<T> clz) {
        try {
            return objectMapper.readValue(bytes, clz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
