package com.abahafart.infra.repository.entity;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NationalityPersonEntity extends PanacheEntity {

  private Instant createdAt;
  private Instant updatedAt;
  private long idPerson;
  private long idCountry;
}
