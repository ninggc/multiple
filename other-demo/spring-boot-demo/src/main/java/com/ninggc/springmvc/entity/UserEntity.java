package com.ninggc.springmvc.entity;

import com.ninggc.util.morphia.domain.IMorphiaPO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.Document;

@Data
@Accessors(chain = true)
public class UserEntity implements IMorphiaPO {

   private String username;
   private String token;

   @Override
   public Document toDocument() {
      return null;
   }
}
