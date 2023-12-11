package com.abahafart.infra.repository;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class NationalityPersonEntity extends PanacheEntity {

  private Instant createdAt;
  private Instant updatedAt;
  private long idPerson;
  private long idCountry;

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

  public long getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(long idPerson) {
    this.idPerson = idPerson;
  }

  public long getIdCountry() {
    return idCountry;
  }

  public void setIdCountry(long idCountry) {
    this.idCountry = idCountry;
  }
}
