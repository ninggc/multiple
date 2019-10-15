package com.ninggc.multipledb.mysql.hibernate.entity.common;

import com.ninggc.multipledb.mysql.hibernate.config.DeleteEnum;
import com.ninggc.multipledb.mysql.hibernate.entity.converter.DeleteEnumConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "create_date", nullable = false)
    protected Date createDate;
    @Column(name = "update_date", nullable = true)
    protected Date updateDate;


}
