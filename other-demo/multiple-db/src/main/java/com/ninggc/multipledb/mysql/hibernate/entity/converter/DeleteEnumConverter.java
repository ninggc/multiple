package com.ninggc.multipledb.mysql.hibernate.entity.converter;

import com.ninggc.multipledb.mysql.hibernate.config.DeleteEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DeleteEnumConverter implements AttributeConverter<DeleteEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DeleteEnum deleteEnum) {
        return deleteEnum == null ? null : deleteEnum.value();
    }

    @Override
    public DeleteEnum convertToEntityAttribute(Integer integer) {
        return integer == null ? null : DeleteEnum.get(integer);
    }
}