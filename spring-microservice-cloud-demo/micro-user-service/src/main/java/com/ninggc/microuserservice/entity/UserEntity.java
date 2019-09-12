package com.ninggc.microuserservice.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserEntity {

   private String username;
   private String token;

}
