package com.ninggc.jsondemo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.util.StringUtils;


/**
 * @description: jackson使用
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/6/16 11:40
 * @version:v1.0
 */
public class JacksonUtil {

    public static ObjectMapper mapper = new ObjectMapper();

    /**
     * 解析json 成 map结构
     *
     * @param json json
     * @param <K>  key
     * @param <V>  value
     * @return Map<K, V>
     */
    public static <K, V> Optional<Map<K, V>> decodeJsonToMap(String json) {
        if (StringUtils.isEmpty(json)) {
            return Optional.empty();
        }
        try {
            Map<K, V> obj = mapper.readValue(json, new TypeReference<Map<K, V>>() {
            });
            return Optional.of(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * 解析json 成 list结构
     *
     * @param json json
     * @param <V>  value
     * @return List<V>
     */
    public static <V> Optional<List<V>> decodeJsonToList(String json) {
        if (StringUtils.isEmpty(json)) {
            return Optional.empty();
        }
        try {
            List<V> obj = mapper.readValue(json, new TypeReference<List<V>>() {
            });
            return Optional.of(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    /**
     * 解析json 成 list结构
     *
     * @param json json
     * @param <V>  value
     * @return List<V>
     */
    public static <V> Optional<List<V>> decodeJsonToList(String json, Class clazz) {
        if (StringUtils.isEmpty(json)) {
            return Optional.empty();
        }
        try {
            List<V> obj = mapper.readValue(json, getCollectionType(ArrayList.class, clazz));
            return Optional.of(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * 解析json 成 set结构
     *
     * @param json json
     * @param <V>  value
     * @return Set<V>
     */
    public static <V> Optional<Set<V>> decodeJsonToSet(String json) {
        if (StringUtils.isEmpty(json)) {
            return Optional.empty();
        }
        try {
            Set<V> obj = mapper.readValue(json, new TypeReference<Set<V>>() {
            });
            return Optional.of(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * 解析json 成 clazz
     *
     * @param json  json
     * @param clazz class
     * @param <T>   具体类型
     * @return Class<T>
     */
    public static <T> Optional<T> readValue(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json) || clazz == null) {
            return Optional.empty();
        }
        try {
            return Optional.of(mapper.readValue(json, clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static String writeValueAsString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
