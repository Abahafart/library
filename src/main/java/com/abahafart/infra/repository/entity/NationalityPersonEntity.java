package com.abahafart.infra.repository.entity;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbl_nationality")
public class NationalityPersonEntity extends PanacheEntity {

  private Instant createdAt;
  private Instant updatedAt;
  private long idPerson;
  private long idCountry;
}
