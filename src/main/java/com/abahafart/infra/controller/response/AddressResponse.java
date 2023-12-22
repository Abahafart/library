package com.abahafart.infra.controller.response;

import java.time.Instant;

import io.smallrye.mutiny.Uni;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

  private long id;
  private String street;
  private String number;
  private String neighborhood;
  private String municipality;
  private String state;
  private String zipCode;
  private Instant createdAt;
  private long idPerson;
  private long idCountry;
  private CountryResponse country;
  private PersonResponse person;
}
