package com.abahafart.infra.repository.entity;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Cacheable
@Getter
@Setter
@Entity(name = "tbl_country")
public class CountryEntity {

  @Id @GeneratedValue
  private Long id;
  private String name;
  private String description;
  private String shortVersion;
  private Instant createdAt;
  private Instant updatedAt;
}
