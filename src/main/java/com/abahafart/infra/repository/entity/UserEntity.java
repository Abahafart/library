package com.abahafart.infra.repository.entity;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Cacheable
@Getter
@Setter
@Entity(name = "tbl_user")
public class UserEntity extends PanacheEntity {

  private String userName;
  private String password;
  private String email;
  private Instant createdAt;
  private Instant updatedAt;
  private long idStatus;
  private long idPerson;
}
