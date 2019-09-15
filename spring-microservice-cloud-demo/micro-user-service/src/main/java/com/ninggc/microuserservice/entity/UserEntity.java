package com.ninggc.microuserservice.entity;

import com.ninggc.util.morphia.domain.IMorphiaPO;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.PrePersist;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@Accessors(chain = true)
@Entity("user")
public class UserEntity implements IMorphiaPO {

   @Id
   private ObjectId id;
   private String username;
   private String token;
   private String cookie;
   private Date createDate;
   private Date updateDate;

   @PrePersist
   public void prePersist() {
      Date now = new Date();
      createDate = createDate == null ? now : createDate;
      updateDate = now;
   }

   @Override
   public Document toDocument() {
      return null;
   }
}
