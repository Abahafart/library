package com.abahafart.infra.repository;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class UserEntity extends PanacheEntity {

  private String userName;
  private String password;
  private String email;
  private Instant createdAt;
  private Instant updatedAt;
  private long idStatus;
  private long idPerson;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getIdStatus() {
    return idStatus;
  }

  public void setIdStatus(long idStatus) {
    this.idStatus = idStatus;
  }

  public long getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(long idPerson) {
    this.idPerson = idPerson;
  }
}
