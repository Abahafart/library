package com.abahafart.infra.repository.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Cacheable
@Getter
@Setter
@Entity(name = "tbl_status")
public class StatusEntity extends PanacheEntity {

  private String description;
  private String type;
  private String createdAt;
}
