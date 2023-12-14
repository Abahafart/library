package com.abahafart.infra.repository.entity;

import java.time.Instant;
import java.time.LocalDate;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_person")
public class PersonEntity {

  @Id @GeneratedValue
  private Long id;
  private String name;
  private String surname;
  private String fullName;
  private LocalDate birthDate;
  private Instant createdAt;
  private Instant updatedAt;
}
