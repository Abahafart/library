package com.abahafart.infra.repository;

import java.time.Instant;
import java.time.LocalDate;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class PersonEntity extends PanacheEntity {

  private String name;
  private String surname;
  private String fullName;
  private LocalDate birthDate;
  private Instant createdAt;
  private Instant updatedAt;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
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
}
