package net.zqj.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode str2JsonNode(String str){
        try {
           return objectMapper.readTree(str);
        }catch (Exception e){
            return null;
        }
    }
}
