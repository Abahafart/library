package com.abahafart.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDO {

  private String userName;
  private String password;
  private String email;
  private Instant createdAt;
  private Instant updatedAt;
  private PersonDO person;
  private StatusDO status;
}
