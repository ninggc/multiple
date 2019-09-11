package com.ninggc.demo.morphiademo.morphia.domain;

import com.ninggc.demo.morphiademo.morphia.util.DeleteEnum;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.PrePersist;
import dev.morphia.annotations.Property;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Entity("qs_answer")
public class MorphiaQsAnswerPO implements IMorphiaPO {
    @Id
    @Property("_id")
    private ObjectId id;
    @Property("question_id")
    private Long questionId;
    @Property("map")
    private Map<String, String> map;
    @Property("patient_id")
    private Long patientId;
    @Property("task_id")
    private Long taskId;
    private Long version;
    @Property("delete_flag")
    private Integer deleteFlag;
    @Property("create_date")
    private Date createDate;
    @Property("update_date")
    private Date updateDate;

    @PrePersist
    private void prePersist() {
//        不在数据库中存空map以防止对map的空引用
        map = map == null ? new HashMap<>() : map;
        deleteFlag = deleteFlag == null ? DeleteEnum.NOT.value() : deleteFlag;
        createDate = createDate == null ? new Date() : createDate;
        updateDate = new Date();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public DeleteEnum getDeleteFlag() {
        return DeleteEnum.get(deleteFlag);
    }

    /**
     * @see MorphiaQsAnswerPO#prePersist 持久化之前自动设置
     * @param deleteFlag
     */
    public void setDeleteFlag(DeleteEnum deleteFlag) {
        this.deleteFlag = deleteFlag.value();
    }

    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @see MorphiaQsAnswerPO#prePersist 持久化之前自动设置
     * @param createDate
     */
    @Deprecated
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @see MorphiaQsAnswerPO#prePersist 持久化之前自动设置
     * @param updateDate
     */
    @Deprecated
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 使用MongoDB Java Drive时用到
     * 等到Morphia支持事务时重构这部分
     */
    @SuppressWarnings("all")
    public Document toDocument() {
        Document document = new Document();
        document.put("_id", id);
        document.put("question_id", questionId);
        document.put("map", map);
        document.put("patient_id", patientId);
        document.put("task_id", taskId);
        document.put("version", version);
        document.put("delete_flag", deleteFlag);
        document.put("create_date", createDate);
        document.put("update_date", updateDate);
        for (Iterator<Map.Entry<String, Object>> it = document.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> entry = it.next();
            if (entry.getValue() == null) {
                it.remove();
            }
        }
        return document;
    }

}
