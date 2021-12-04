package com.ninggc.mongodemo.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
public class MongoValuePO {

    @MongoId(value = FieldType.STRING)
    private String id;

    @Field("value")
    private Map<String, Object> value;

    @Version
    private Integer version;
}
