package com.ninggc.multipledb.mysql.hibernate.entity;

import com.ninggc.multipledb.mysql.hibernate.config.DeleteEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ninggc
 * @create 2019-10-14 11:02
 * @description nothing
 */
@Data
@Table(schema = "qs_patient")
public class QuestionEntity {
    @Id
    private Long id;

    @Column(name = "delete_flag")
    DeleteEnum deleteFlag;
}
