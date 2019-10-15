package com.ninggc.multipledb.mysql.hibernate.entity.converter;

import com.ninggc.multipledb.mysql.hibernate.config.DeleteEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DeleteEnumConverter implements AttributeConverter<DeleteEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DeleteEnum deleteEnum) {
        return deleteEnum.value();
    }

    @Override
    public DeleteEnum convertToEntityAttribute(Integer integer) {
        return DeleteEnum.get(integer);
    }
}