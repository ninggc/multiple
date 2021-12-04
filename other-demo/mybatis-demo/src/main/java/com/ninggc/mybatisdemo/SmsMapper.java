package com.ninggc.mybatisdemo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SmsMapper {
    @Select("select * from bd_sms_record")
    public Object select();
}
