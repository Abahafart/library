package com.abahafart.infra.repository;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class CountryEntity extends PanacheEntity {

  private String name;
  private String description;
  private String shortVersion;
  private Instant createdAt;
  private Instant updatedAt;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getShortVersion() {
    return shortVersion;
  }

  public void setShortVersion(String shortVersion) {
    this.shortVersion = shortVersion;
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
