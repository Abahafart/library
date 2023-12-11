package com.abahafart.infra.repository.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Cacheable
@Getter
@Setter
public class StatusEntity extends PanacheEntity {

  private String description;
  private String type;
  private String createdAt;
}
