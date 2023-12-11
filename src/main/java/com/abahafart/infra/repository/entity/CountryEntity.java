package com.abahafart.infra.repository.entity;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Cacheable
@Getter
@Setter
public class CountryEntity extends PanacheEntity {

  private String name;
  private String description;
  private String shortVersion;
  private Instant createdAt;
  private Instant updatedAt;
}
