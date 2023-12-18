package com.abahafart.infra.repository.entity;

import java.time.Instant;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Cacheable
@Entity(name = "tbl_address")
public class AddressEntity {
  @Id @GeneratedValue
  private Long id;
  private String street;
  private String number;
  private String neighborhood;
  private String municipality;
  private String state;
  private String zipCode;
  private Instant createdAt;
  private long idPerson;
  private long idCountry;
}
