package com.abahafart.infra.repository.entity;

import java.time.Instant;
import java.time.LocalDate;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Cacheable
@Getter
@Setter
@Entity(name = "tbl_person")
public class PersonEntity extends PanacheEntity {

  private String name;
  private String surname;
  private String fullName;
  private LocalDate birthDate;
  private Instant createdAt;
  private Instant updatedAt;
}
