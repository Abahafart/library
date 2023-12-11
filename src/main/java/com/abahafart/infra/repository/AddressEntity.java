package com.abahafart.infra.repository;

import java.time.Instant;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class AddressEntity extends PanacheEntity {

  private String street;
  private String number;
  private String neighborhood;
  private String municipality;
  private String state;
  private String zipCode;
  private Instant createdAt;
  private long idPerson;
  private long idCountry;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getMunicipality() {
    return municipality;
  }

  public void setMunicipality(String municipality) {
    this.municipality = municipality;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
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
