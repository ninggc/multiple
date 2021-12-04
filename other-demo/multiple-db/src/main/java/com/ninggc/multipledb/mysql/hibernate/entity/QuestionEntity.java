package com.ninggc.multipledb.mysql.hibernate.entity;

import com.ninggc.multipledb.mysql.hibernate.config.DeleteEnum;
import com.ninggc.multipledb.mysql.hibernate.entity.common.CommonEntity;
import com.ninggc.multipledb.mysql.hibernate.entity.converter.DeleteEnumConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ninggc
 * @create 2019-10-14 11:02
 * @description nothing
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "qs_patient", schema = "question")
public class QuestionEntity extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "create_date", nullable = false)
    protected Date createDate;
    @Column(name = "update_date")
    protected Date updateDate;

    @Convert(converter = DeleteEnumConverter.class)
    @Column(name = "delete_flag")
    protected DeleteEnum deleteFlag;

    @PrePersist
    protected void prePersist() {
        Date now = new Date();
        createDate = createDate == null ? now : createDate;
        updateDate = updateDate == null ? now : updateDate;
    }
}
